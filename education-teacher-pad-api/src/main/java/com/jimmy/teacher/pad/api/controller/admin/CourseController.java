package com.jimmy.teacher.pad.api.controller.admin;

import com.jimmy.core.local.thread.LoginLocalThread;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.model.dto.CourseInfoDTO;
import com.jimmy.mvc.common.model.transfer.CourseInfoDTOTransfer;
import com.jimmy.service.CourseInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(tags = "课程信息", description = "课程信息")
@Controller
@RequestMapping("/admin/course")
public class CourseController {
    @Autowired
    private CourseInfoService courseInfoService;

    @ResponseBody
    @PostMapping("/save")
    @ApiOperation("保存课程信息")
    public Result<Boolean> save(CourseInfoDTO courseInfoDTO) {
        courseInfoDTO.setTeacherId(LoginLocalThread.get());
        courseInfoService.save(CourseInfoDTOTransfer.INSTANCE.toCourseInfo(courseInfoDTO));
        return ResultBuilder.ok(Boolean.TRUE);
    }





}
