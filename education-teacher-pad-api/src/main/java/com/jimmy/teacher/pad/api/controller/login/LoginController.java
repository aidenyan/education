package com.jimmy.teacher.pad.api.controller.login;

import com.jimmy.core.local.thread.LoginLocalThread;
import com.jimmy.core.model.dto.UserLoginBaseDTO;
import com.jimmy.dao.entity.TeacherStaffInfo;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.enums.ResultCodeEnum;
import com.jimmy.mvc.common.model.dto.LoginDTO;
import com.jimmy.mvc.common.utils.PasswordUtils;
import com.jimmy.service.TeacherStaffInfoService;
import com.jimmy.service.TokenService;
import com.jimmy.teacher.pad.api.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Api(value = "��¼/�˳�", description = "��¼�Լ��˳�API")
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {


    @Autowired
    private TokenService tokenService;


    @Autowired
    private TeacherStaffInfoService teacherStaffInfoService;



    @ResponseBody
    @PostMapping("/in")
    @ApiOperation("�����̨��¼�ӿ�")
    public Result<String> in(@Validated(LoginDTO.Pad.class) @RequestBody LoginDTO loginDTO) {
        TeacherStaffInfo teacherStaffInfo = teacherStaffInfoService.findByName(loginDTO.getUserName());
        if (teacherStaffInfo == null) {
            return ResultBuilder.error(ResultCodeEnum.ACCOUNT_NOT_EXIST);
        }
        if (!PasswordUtils.isEquals(loginDTO.getPassword(), teacherStaffInfo.getPassword())) {
            return ResultBuilder.error(ResultCodeEnum.PASSWORD_ERROR);
        }
        String token = UUID.randomUUID().toString();
        token = token.replace("-", "");
        UserLoginBaseDTO userLoginBaseDTO = new UserLoginBaseDTO();
        userLoginBaseDTO.setUseId(teacherStaffInfo.getId());
        userLoginBaseDTO.setToken(token);
        String headerToken = tokenService.createToken(userLoginBaseDTO);
        teacherStaffInfoService.updatePadAppToken(teacherStaffInfo.getId(), token);
        return ResultBuilder.ok(headerToken);
    }
}
