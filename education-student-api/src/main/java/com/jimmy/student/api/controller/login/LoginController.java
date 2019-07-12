package com.jimmy.student.api.controller.login;

import com.jimmy.common.utils.StringUtils;
import com.jimmy.core.enums.ResultCoreEnum;
import com.jimmy.core.model.dto.UserLoginBaseDTO;
import com.jimmy.dao.entity.*;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.enums.ResultCodeEnum;
import com.jimmy.mvc.common.model.dto.ClassRoomDTO;
import com.jimmy.mvc.common.model.dto.MachineInfoDTO;
import com.jimmy.mvc.common.model.dto.StudentLoginDTO;
import com.jimmy.mvc.common.model.transfer.ClassRoomDTOTransfer;
import com.jimmy.mvc.common.model.transfer.MachineInfoTOTransfer;
import com.jimmy.mvc.common.utils.PasswordUtils;
import com.jimmy.service.*;
import com.jimmy.student.api.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Api(value = "登录以及登录之前的接口", description = "登录以及登录之前的接口API")
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {


    @Autowired
    private TokenService tokenService;

    @Autowired
    private CourseInfoService courseInfoService;

    @Autowired
    private ClassRoomService classRoomService;


    @Autowired
    private StudentInfoService studentInfoService;

    @Autowired
    private CourseStudentService courseStudentService;


    @ResponseBody
    @GetMapping("/room/list")
    @ApiOperation("获取所有的教室")
    public Result<List<ClassRoomDTO>> listRoom(String name) {
        List<ClassRoomInfo> classRoomInfoList = classRoomService.list(name);
        return ResultBuilder.ok(ClassRoomDTOTransfer.INSTANCE.toClassRoomDTOList(classRoomInfoList));
    }

    @ResponseBody
    @GetMapping("/machine/list")
    @ApiOperation("获取所有的教室")
    public Result<List<MachineInfoDTO>> listMachine(Long roomId) {
        List<MachineInfo> machineInfoList = classRoomService.listById(roomId);
        return ResultBuilder.ok(MachineInfoTOTransfer.INSTANCE.toMachineInfoDTOList(machineInfoList));
    }


    @ResponseBody
    @PostMapping("/in")
    @ApiOperation("管理后台登录接口")
    public Result<String> in(@Validated @RequestBody StudentLoginDTO studentLoginDTO) {
        StudentInfo studentInfo = studentInfoService.findByName(studentLoginDTO.getUserName());
        if (studentInfo == null) {
            return ResultBuilder.error(ResultCodeEnum.ACCOUNT_NOT_EXIST);
        }
        if (!PasswordUtils.isEquals(studentLoginDTO.getPassword(), studentInfo.getPassword())) {
            return ResultBuilder.error(ResultCodeEnum.PASSWORD_ERROR);
        }
        String token = UUID.randomUUID().toString();
        token = token.replace("-", "");
        MachineInfo machineInfo = classRoomService.findMachine(studentLoginDTO.getMachinaId());
        if (machineInfo == null) {
            ResultBuilder.error(ResultCoreEnum.RESULT_PARAMETER_EXCEPTION);
        }
        CourseInfo courseInfo = courseInfoService.findByRoomId(machineInfo.getRoomId());
        if (courseInfo == null) {
           return ResultBuilder.error(ResultCodeEnum.COURSE_NOT_EXIST);
        }
        List<CourseStudent> courseStudentList = courseStudentService.find(courseInfo.getId(), studentInfo.getId(), studentLoginDTO.getMachinaId());
        if(CollectionUtils.isEmpty(courseStudentList)){
            return ResultBuilder.error(ResultCodeEnum.MACHINE_STUDENT_NOT_EXIST);
        }
        CourseStudent courseStudent = courseStudentList.stream().findFirst().get();
        UserLoginBaseDTO userLoginBaseDTO = new UserLoginBaseDTO();
        userLoginBaseDTO.setUseId(courseStudent.getId());
        userLoginBaseDTO.setToken(token);
        String headerToken = tokenService.createToken(userLoginBaseDTO);
        studentInfoService.updateToken(token, studentInfo.getId());
        return ResultBuilder.ok(headerToken);
    }
}
