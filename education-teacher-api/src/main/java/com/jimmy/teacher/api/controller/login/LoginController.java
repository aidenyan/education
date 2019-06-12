package com.jimmy.teacher.api.controller.login;

import com.jimmy.core.local.thread.LoginLocalThread;
import com.jimmy.core.model.dto.UserLoginBaseDTO;
import com.jimmy.dao.entity.ClassRoomInfo;
import com.jimmy.dao.entity.TeacherStaffInfo;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.enums.ResultCodeEnum;
import com.jimmy.mvc.common.utils.PasswordUtils;
import com.jimmy.service.ClassRoomService;
import com.jimmy.service.TeacherStaffInfoService;
import com.jimmy.service.TokenService;
import com.jimmy.teacher.api.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Api(tags = "登录/退出", description = "登录以及退出API")
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {


    @Autowired
    private TokenService tokenService;


    @Autowired
    private ClassRoomService classRoomService;
    @Autowired
    private TeacherStaffInfoService teacherStaffInfoService;


    @ResponseBody
    @PostMapping("/out")
    @ApiOperation("管理后台退出接口")
    public Result<Void> out() {
        teacherStaffInfoService.updateAppToken(LoginLocalThread.get(), "", null);
        return ResultBuilder.ok(null);
    }

    @ResponseBody
    @PostMapping("/in")
    @ApiOperation("管理后台登录接口")
    @ApiImplicitParams({@ApiImplicitParam(value = "用户名称", name = "userName", paramType = "query", required = true),
            @ApiImplicitParam(value = "密码", name = "password", paramType = "query", required = true),
            @ApiImplicitParam(value = "教师编码", name = "roomNo", paramType = "query", required = true),
    })
    public Result<String> in(@RequestParam String userName, @RequestParam String password, @RequestParam Long roomId) {
        TeacherStaffInfo teacherStaffInfo = teacherStaffInfoService.findByName(userName);
        if (teacherStaffInfo == null) {
            return ResultBuilder.error(ResultCodeEnum.ACCOUNT_NOT_EXIST);
        }
        if (!PasswordUtils.isEquals(password, teacherStaffInfo.getPassword())) {
            return ResultBuilder.error(ResultCodeEnum.PASSWORD_ERROR);
        }
        ClassRoomInfo classRoomInfo = classRoomService.detail(roomId);
        if (classRoomInfo == null) {
            return ResultBuilder.error(ResultCodeEnum.ROOM_NOT_EXIST);
        }
        String token = UUID.randomUUID().toString();
        token = token.replace("-", "");
        UserLoginBaseDTO userLoginBaseDTO = new UserLoginBaseDTO();
        userLoginBaseDTO.setUseId(teacherStaffInfo.getId());
        userLoginBaseDTO.setToken(token);
        userLoginBaseDTO.setWorkAddressId(classRoomInfo.getId());
        String headerToken = tokenService.createToken(userLoginBaseDTO);
        teacherStaffInfoService.updateAppToken(teacherStaffInfo.getId(), token, classRoomInfo.getId());
        return ResultBuilder.ok(headerToken);
    }
}
