package com.jimmy.teacher.api.controller.login;

import com.jimmy.core.local.thread.LoginLocalThread;
import com.jimmy.core.model.dto.UserLoginBaseDTO;
import com.jimmy.dao.entity.ClassRoomInfo;
import com.jimmy.dao.entity.TeacherStaffInfo;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.enums.ResultCodeEnum;
import com.jimmy.mvc.common.model.dto.ClassRoomDTO;
import com.jimmy.mvc.common.model.dto.LoginDTO;
import com.jimmy.mvc.common.model.transfer.ClassRoomDTOTransfer;
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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Api(value = "登录/退出", description = "登录以及退出API")
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
    @GetMapping("/room/list")
    @ApiOperation("获取所有的教室")
    public Result<List<ClassRoomDTO>> listRoom(String name) {
        List<ClassRoomInfo> classRoomInfoList = classRoomService.list(name);
        return ResultBuilder.ok(ClassRoomDTOTransfer.INSTANCE.toClassRoomDTOList(classRoomInfoList));
    }




    @ResponseBody
    @PostMapping("/in")
    @ApiOperation("管理后台登录接口")
    public Result<String> in(@Validated(LoginDTO.Teacher.class) @RequestBody LoginDTO loginDTO) {
        TeacherStaffInfo teacherStaffInfo = teacherStaffInfoService.findByName(loginDTO.getUserName());
        if (teacherStaffInfo == null) {
            return ResultBuilder.error(ResultCodeEnum.ACCOUNT_NOT_EXIST);
        }
        if (!PasswordUtils.isEquals(loginDTO.getPassword(), teacherStaffInfo.getPassword())) {
            return ResultBuilder.error(ResultCodeEnum.PASSWORD_ERROR);
        }
        ClassRoomInfo classRoomInfo = classRoomService.detail(loginDTO.getRoomId());
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
