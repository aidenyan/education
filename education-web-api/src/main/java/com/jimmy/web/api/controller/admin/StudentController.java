package com.jimmy.web.api.controller.admin;

import com.jimmy.core.base.Page;
import com.jimmy.dao.entity.StudentInfo;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.model.dto.StudentInfoDTO;
import com.jimmy.mvc.common.model.transfer.StudentInfoDTOTransfer;
import com.jimmy.service.StudentInfoService;
import com.jimmy.web.api.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    private StudentInfoService studentInfoService;

    @ResponseBody
    @GetMapping("/page")
    @ApiOperation("学生信息")
    public Result<Page<StudentInfoDTO>> page(String name, Integer pageNo, Integer pageSize) {
        this.setPage(pageNo, pageSize);
        List<StudentInfo> list = studentInfoService.list(name);
        Page<StudentInfoDTO> resultList = getPageResult(list, target -> StudentInfoDTOTransfer.INSTANCE.toStudentInfoDTOList(target));
        return ResultBuilder.ok(resultList);
    }

    @ResponseBody
    @GetMapping("/save")
    @ApiOperation("保存学生信息")
    public Result<Void> save(@Validated @RequestBody StudentInfoDTO studentInfoDTO) {
        studentInfoService.save(StudentInfoDTOTransfer.INSTANCE.toStudentInfo(studentInfoDTO));
        return ResultBuilder.ok(null);
    }

    @ResponseBody
    @GetMapping("/info")
    @ApiOperation("查询学生信息")
    public Result<StudentInfoDTO> info(Long id) {
        return ResultBuilder.ok(StudentInfoDTOTransfer.INSTANCE.toStudentInfoDTO(studentInfoService.findById(id)));
    }
    @ResponseBody
    @PostMapping("/deleted/{id}")
    @ApiOperation("删除学生信息")
    public Result<Void> deleted(@PathVariable("id") Long id) {
        studentInfoService.delete(id);
        return ResultBuilder.ok(null);
    }
}
