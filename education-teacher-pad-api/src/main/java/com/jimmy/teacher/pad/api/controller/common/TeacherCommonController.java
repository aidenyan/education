package com.jimmy.teacher.pad.api.controller.common;

import com.jimmy.dao.entity.AppVersion;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.service.AppVersionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: TeacherCommonController
 * @Description:
 * @author: aiden
 * @date: 2019/6/17/017.
 */
@Api(value = "教师部分的公共功能", description = "教师部分的公共功能API")
@Controller
@RequestMapping("/teacher/common")
public class TeacherCommonController {


    private final static String APP_NAME = "app_pad";

    @Autowired
    private AppVersionService appVersionService;

    @ApiOperation("获取app版本信息")
    @ResponseBody
    @GetMapping("/app/version")
    public Result<AppVersion> findAppVersion() {
        return ResultBuilder.ok(appVersionService.find(APP_NAME));
    }
}
