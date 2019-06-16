package com.jimmy.web.api.controller.login;

import com.jimmy.dao.entity.MenuInfo;
import com.jimmy.dao.entity.TeacherStaffInfo;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.enums.ResultCodeEnum;
import com.jimmy.mvc.common.utils.PasswordUtils;
import com.jimmy.service.MenuInfoService;
import com.jimmy.service.TeacherStaffInfoService;
import com.jimmy.web.api.controller.BaseController;
import com.jimmy.web.api.service.SessionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Api(tags = "登录/退出", description = "登录以及退出API")
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {
    @Autowired
    private SessionService sessionService;

    @Autowired
    private MenuInfoService menuInfoService;


    @Autowired
    private TeacherStaffInfoService teacherStaffInfoService;


    @ResponseBody
    @GetMapping("/out")
    @ApiOperation("管理后台退出接口")
    public Result<Void> out() {
        sessionService.out();
        return ResultBuilder.ok(null);
    }

    @ResponseBody
    @GetMapping("/in")
    @ApiOperation("管理后台登录接口")
    @ApiImplicitParams({@ApiImplicitParam(value = "用户名称", name = "userName", paramType = "query", required = true),
            @ApiImplicitParam(value = "密码", name = "password", paramType = "query", required = true)})
    public Result<Void> in(String userName, String password) {
        TeacherStaffInfo teacherStaffInfo = teacherStaffInfoService.findByName(userName);
        if (teacherStaffInfo == null) {
            return ResultBuilder.error(ResultCodeEnum.ACCOUNT_NOT_EXIST);
        }
        if (!PasswordUtils.isEquals(password, teacherStaffInfo.getPassword())) {
            return ResultBuilder.error(ResultCodeEnum.PASSWORD_ERROR);
        }
        sessionService.save(teacherStaffInfo);
        List<MenuInfo> menuInfoList = menuInfoService.list(teacherStaffInfo.getId());
        sessionService.save(menuInfoList);
        return ResultBuilder.ok(null);
    }
}
