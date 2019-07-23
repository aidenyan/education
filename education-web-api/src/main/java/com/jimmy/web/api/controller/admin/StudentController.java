package com.jimmy.web.api.controller.admin;

import com.jimmy.common.utils.StringUtils;
import com.jimmy.core.base.Page;
import com.jimmy.dao.entity.ClassMate;
import com.jimmy.dao.entity.StudentInfo;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.model.dto.StudentInfoDTO;
import com.jimmy.mvc.common.model.transfer.StudentInfoDTOTransfer;
import com.jimmy.service.ClassMateService;
import com.jimmy.service.StudentInfoService;
import com.jimmy.web.api.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: StudentController
 * @Description:
 * @author: aiden
 * @date: 2019/7/11/011.
 */
@Api(value = "学生相关的处理", description = "学生相关的处理API")
@Controller
@RequestMapping("/admin/student")
public class StudentController extends BaseController {

    @Autowired
    private ClassMateService classMateService;

    @Autowired
    private StudentInfoService studentInfoService;


    @ResponseBody
    @GetMapping("/page")
    @ApiOperation("学生信息")
    public Result<Page<StudentInfoDTO>> page(String name, Integer pageNo, Integer pageSize) {
        this.setPage(pageNo, pageSize);
        List<StudentInfo> list = studentInfoService.list(name);
        Map<Long, String> classMateMap = new HashMap<>();
        if (!CollectionUtils.isEmpty(list)) {
            List<Long> classmateIdList = new ArrayList<>();
            list.forEach(studentInfo -> classmateIdList.add(studentInfo.getClassmateId()));
            List<ClassMate> classMateList = classMateService.listById(classmateIdList);
            if (!CollectionUtils.isEmpty(classMateList)) {
                classMateList.forEach(classMate -> classMateMap.put(classMate.getId(), classMate.getName()));
            }
        }

        Page<StudentInfoDTO> resultList = getPageResult(list, target -> StudentInfoDTOTransfer.INSTANCE.toStudentInfoDTOList(target));
        if (!CollectionUtils.isEmpty(resultList.getResult())) {
            resultList.getResult().forEach(studentInfoDTO -> {
                studentInfoDTO.setClassmateName(classMateMap.get(studentInfoDTO.getClassmateId()));
            });
        }
        return ResultBuilder.ok(resultList);
    }

    @ResponseBody
    @PostMapping("/save")
    @ApiOperation("保存学生信息")
    public Result<Void> save(@Validated @RequestBody StudentInfoDTO studentInfoDTO) {
        StudentInfo studentInfo=StudentInfoDTOTransfer.INSTANCE.toStudentInfo(studentInfoDTO);
        if(StringUtils.isNotBlank(studentInfoDTO.getNPw())){
            studentInfo.setPassword(studentInfoDTO.getNPw());
        }
        studentInfoService.save(studentInfo);
        return ResultBuilder.ok(null);
    }

    @ResponseBody
    @GetMapping("/info")
    @ApiOperation("查询学生信息")
    public Result<StudentInfoDTO> info(Long id) {
        return ResultBuilder.ok(StudentInfoDTOTransfer.INSTANCE.toStudentInfoDTO(studentInfoService.findById(id)));
    }

    @ResponseBody
    @GetMapping("/class/list_all")
    @ApiOperation("班级信息")
    public Result<List<ClassMate>> listAll() {
        return ResultBuilder.ok(classMateService.listAll());
    }

    @ResponseBody
    @PostMapping("/deleted/{id}")
    @ApiOperation("删除学生信息")
    public Result<Void> deleted(@PathVariable("id") Long id) {
        studentInfoService.delete(id);
        return ResultBuilder.ok(null);
    }
}
