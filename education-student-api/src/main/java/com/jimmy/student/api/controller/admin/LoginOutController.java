package com.jimmy.student.api.controller.admin;

import com.jimmy.core.local.thread.LoginLocalThread;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.service.StudentInfoService;
import com.jimmy.student.api.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: LoginOutController
 * @Description:
 * @author: aiden
 * @date: 2019/7/8/008.
 */
@Api(value = "课程课件信息", description = "课程课件信息API")
@Controller
@RequestMapping("/admin/login")
public class LoginOutController extends BaseController {


    @Autowired
    private StudentInfoService studentInfoService;

    @ResponseBody
    @PostMapping("/out")
    @ApiOperation("管理后台退出接口")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<Void> out() {
        studentInfoService.updateToken("", LoginLocalThread.get());
        return ResultBuilder.ok(null);
    }
}
