package com.jimmy.teacher.api.controller.admin;

import com.jimmy.core.enums.ResultCoreEnum;
import com.jimmy.dao.entity.ClassMate;
import com.jimmy.dao.entity.StudentInfo;
import com.jimmy.dao.entity.TemporaryClassMate;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.enums.ResultCodeEnum;
import com.jimmy.mvc.common.model.dto.StudentInfoDTO;
import com.jimmy.mvc.common.model.transfer.StudentInfoDTOTransfer;
import com.jimmy.service.ClassMateService;
import com.jimmy.service.StudentInfoService;
import com.jimmy.service.TemporaryClassMateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: ClassMateController
 * @Description:
 * @author: aiden
 * @date: 2019/6/12/012.
 */
@Api(tags = "班级/临时班级信息", description = "课程课件信息API")
@Controller
@RequestMapping("/admin/class_mate")
public class ClassMateController {

    @Autowired
    private ClassMateService classMateService;

    @Autowired
    private StudentInfoService studentInfoService;

    @Autowired
    private TemporaryClassMateService temporaryClassMateService;


    @ApiOperation("获取班级信息列表")
    @ResponseBody
    @GetMapping("/list")
    public Result<List<ClassMate>> list(String name) {
        List<ClassMate> classMateList = classMateService.list(name);
        return ResultBuilder.error(ResultCodeEnum.OK, classMateList);
    }

    @ApiOperation("通过选择的班级返回学生信息")
    @ResponseBody
    @GetMapping("/temp/student/list")
    public Result<List<StudentInfoDTO>> list(Long[] classMateIdArray, Long courseId, String name, String description) {
        if (classMateIdArray == null || classMateIdArray.length == 0) {
            return ResultBuilder.error(ResultCoreEnum.RESULT_PARAMETER_EXCEPTION);
        }

        TemporaryClassMate temporaryClassMate = new TemporaryClassMate();
        temporaryClassMate.setCourseId(courseId);
        temporaryClassMate.setName(name);
        List<StudentInfo> studentInfoList = studentInfoService.listByClassMate(Arrays.asList(classMateIdArray));
        temporaryClassMateService.save(temporaryClassMate, studentInfoList);
        return ResultBuilder.error(ResultCodeEnum.OK, StudentInfoDTOTransfer.INSTANCE.toStudentInfoDTOList(studentInfoList));
    }

    @ApiOperation("已经选择过班级的情况下获取学生信息")
    @ResponseBody
    @GetMapping("/temp/student/list/{courseId}")
    public Result<List<StudentInfoDTO>> list(@PathVariable("courseId") Long courseId) {
        List<StudentInfo> studentInfoList = temporaryClassMateService.findStudentId(courseId);
        return ResultBuilder.error(ResultCodeEnum.OK, StudentInfoDTOTransfer.INSTANCE.toStudentInfoDTOList(studentInfoList));
    }
}
