package com.jimmy.student.api.controller.login;

import com.jimmy.core.enums.ResultCoreEnum;
import com.jimmy.core.local.thread.LoginLocalThread;
import com.jimmy.core.model.dto.UserLoginBaseDTO;
import com.jimmy.dao.entity.*;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.enums.ResultCodeEnum;
import com.jimmy.mvc.common.model.dto.ClassRoomDTO;
import com.jimmy.mvc.common.model.dto.MachineInfoDTO;
import com.jimmy.mvc.common.model.transfer.ClassRoomDTOTransfer;
import com.jimmy.mvc.common.model.transfer.MachineInfoTOTransfer;
import com.jimmy.mvc.common.utils.PasswordUtils;
import com.jimmy.service.*;
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

import java.util.List;
import java.util.UUID;

@Api(tags = "��¼�Լ���¼֮ǰ�Ľӿ�", description = "��¼�Լ���¼֮ǰ�Ľӿ�API")
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
    @PostMapping("/room/list")
    @ApiOperation("��ȡ���еĽ���")
    public Result<List<ClassRoomDTO>> listRoom() {
        List<ClassRoomInfo> classRoomInfoList = classRoomService.list(null);
        return ResultBuilder.ok(ClassRoomDTOTransfer.INSTANCE.toClassRoomDTOList(classRoomInfoList));
    }

    @ResponseBody
    @PostMapping("/machine/list")
    @ApiOperation("��ȡ���еĽ���")
    public Result<List<MachineInfoDTO>> listMachine(Long roomId) {
        List<MachineInfo> machineInfoList = classRoomService.listById(roomId);
        return ResultBuilder.ok(MachineInfoTOTransfer.INSTANCE.toMachineInfoDTOList(machineInfoList));
    }

    @ResponseBody
    @PostMapping("/out")
    @ApiOperation("�����̨�˳��ӿ�")
    public Result<Void> out() {
        studentInfoService.updateToken("", LoginLocalThread.get());
        return ResultBuilder.ok(null);
    }

    @ResponseBody
    @PostMapping("/in")
    @ApiOperation("�����̨��¼�ӿ�")
    @ApiImplicitParams({@ApiImplicitParam(value = "�û�����", name = "userName", paramType = "query", required = true),
            @ApiImplicitParam(value = "����ID", name = "machinaId", paramType = "query", required = true),
            @ApiImplicitParam(value = "����", name = "password", paramType = "query", required = true)})
    public Result<String> in(String userName, String password, Long machinaId) {
        StudentInfo studentInfo = studentInfoService.findByName(userName);
        if (studentInfo == null) {
            return ResultBuilder.error(ResultCodeEnum.ACCOUNT_NOT_EXIST);
        }
        if (!PasswordUtils.isEquals(password, studentInfo.getPassword())) {
            return ResultBuilder.error(ResultCodeEnum.PASSWORD_ERROR);
        }
        String token = UUID.randomUUID().toString();
        token = token.replace("-", "");
        MachineInfo machineInfo = classRoomService.findMachine(machinaId);
        if (machineInfo == null) {
            ResultBuilder.error(ResultCoreEnum.RESULT_PARAMETER_EXCEPTION);
        }
        CourseInfo courseInfo = courseInfoService.findByRoomId(machineInfo.getRoomId());
        List<CourseStudent> courseStudentList = courseStudentService.find(courseInfo.getId(), studentInfo.getId(), machinaId);
        CourseStudent courseStudent = courseStudentList.get(0);
        UserLoginBaseDTO userLoginBaseDTO = new UserLoginBaseDTO();
        userLoginBaseDTO.setUseId(courseStudent.getId());
        userLoginBaseDTO.setToken(token);
        String headerToken = tokenService.createToken(userLoginBaseDTO);
        studentInfoService.updateToken(token, studentInfo.getId());
        return ResultBuilder.ok(headerToken);
    }
}
