package com.jimmy.teacher.pad.api.controller.admin;

import com.jimmy.common.utils.StringUtils;
import com.jimmy.core.enums.ResultCoreEnum;
import com.jimmy.dao.entity.StudentInfo;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.service.StudentInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: StudentController
 * @Description:
 * @author: aiden
 * @date: 2019/6/16/016.
 */

@Api(tags = "学生信息", description = "学生信息")
@Controller
@RequestMapping("/admin/student")
public class StudentController {
    @Autowired
    private StudentInfoService studentInfoService;

    @ResponseBody
    @GetMapping("/list")
    @ApiOperation("学生列表")
    public Result<List<StudentInfo>> list(Long classMateId) {
        if (classMateId == null) {
            return ResultBuilder.error(ResultCoreEnum.RESULT_EXCEPTION_SYS);
        }
        List<StudentInfo> studentInfoList = studentInfoService.listByClassMate(Arrays.asList(classMateId));
        return ResultBuilder.ok(studentInfoList);
    }

    @ResponseBody
    @PostMapping("/save/header")
    @ApiOperation("保存学生头部特征信息")
    public Result<Boolean> saveHeader(String headerInfo, Long studnetId) {
        if (StringUtils.isBlank(headerInfo) || studnetId == null) {
            return ResultBuilder.error(ResultCoreEnum.RESULT_EXCEPTION_SYS);
        }
        studentInfoService.updateHeader(headerInfo, studnetId);
        return ResultBuilder.ok(Boolean.TRUE);
    }
}
