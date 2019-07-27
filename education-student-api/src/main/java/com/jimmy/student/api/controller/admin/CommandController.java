package com.jimmy.student.api.controller.admin;

import com.jimmy.common.utils.StringUtils;
import com.jimmy.dao.entity.CommandInfo;
import com.jimmy.dao.entity.CourseInfo;
import com.jimmy.dao.entity.CourseStudent;
import com.jimmy.dao.entity.MachineInfo;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.enums.ResultCodeEnum;
import com.jimmy.mvc.common.model.dto.CommandDTO;
import com.jimmy.mvc.common.model.dto.CommandDetailDTO;
import com.jimmy.mvc.common.model.dto.CommandMessageDTO;
import com.jimmy.mvc.common.model.dto.RaiseHandDTO;
import com.jimmy.mvc.common.model.enums.CommandTypeEnum;
import com.jimmy.mvc.common.model.enums.DirectionEnum;
import com.jimmy.mvc.common.model.transfer.CommandDTOTransfer;
import com.jimmy.mvc.common.service.CommandQueueService;
import com.jimmy.service.ClassRoomService;
import com.jimmy.service.CommandService;
import com.jimmy.service.CourseInfoService;
import com.jimmy.student.api.config.StudentConfig;
import com.jimmy.student.api.controller.BaseController;
import com.jimmy.student.api.local.thread.CourseStudentLocalThread;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: CommandController
 * @Description:
 * @author: aiden
 * @date: 2019/6/17/017.
 */
@Api(value = "指令信息", description = "指令信息API")
@Controller
@RequestMapping("/admin/command")
@EnableConfigurationProperties(StudentConfig.class)
public class CommandController extends BaseController {


    @Autowired
    private StudentConfig studentConfig;

    @Autowired
    private CourseInfoService courseInfoService;

    @Autowired
    private ClassRoomService classRoomService;

    @Autowired
    private CommandService commandService;

    @Autowired
    private CommandQueueService commandQueueService;

    @ApiOperation("举手请假")
    @ResponseBody
    @PostMapping("/raise_hand")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<Long> askLevel(Long studentId) {
        CommandDetailDTO<RaiseHandDTO> commandDetailDTO = new CommandDetailDTO<>();
        commandDetailDTO.setCommandType(CommandTypeEnum.ASK_LEVEL);
        CourseStudent courseStudent = CourseStudentLocalThread.get();
        CourseInfo courseInfo = courseInfoService.findById(courseStudent.getCourseId());
        if (courseInfo.getUsedTeacherId() == null) {
            return ResultBuilder.error(ResultCodeEnum.COURSE_NOT_START);
        }
        RaiseHandDTO raiseHandDTO = new RaiseHandDTO();
        raiseHandDTO.setMachineId(courseStudent.getMachineId());
        raiseHandDTO.setTeacherId(courseInfo.getTeacherId());
        raiseHandDTO.setStudentId(studentId);
        commandDetailDTO.setDetail(raiseHandDTO);
        commandDetailDTO.setCourseId(courseInfo.getId());
        Long id = using(CommandDTOTransfer.INSTANCE.toCommandDTO(commandDetailDTO));
        return ResultBuilder.ok(id);
    }

    @ApiOperation("举手请假结束")
    @ResponseBody
    @PostMapping("/ask_level_end")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<Long> askLevelEnd(Long studentId) {
        CommandDetailDTO<RaiseHandDTO> commandDetailDTO = new CommandDetailDTO<>();
        commandDetailDTO.setCommandType(CommandTypeEnum.ASK_LEVEL_END);
        CourseStudent courseStudent = CourseStudentLocalThread.get();
        CourseInfo courseInfo = courseInfoService.findById(courseStudent.getCourseId());
        if (courseInfo.getUsedTeacherId() == null) {
            return ResultBuilder.error(ResultCodeEnum.COURSE_NOT_START);
        }
        RaiseHandDTO raiseHandDTO = new RaiseHandDTO();
        raiseHandDTO.setMachineId(courseStudent.getMachineId());
        raiseHandDTO.setTeacherId(courseInfo.getTeacherId());
        raiseHandDTO.setStudentId(studentId);
        commandDetailDTO.setDetail(raiseHandDTO);
        commandDetailDTO.setCourseId(courseInfo.getId());
        Long id = using(CommandDTOTransfer.INSTANCE.toCommandDTO(commandDetailDTO));
        return ResultBuilder.ok(id);
    }

    @ApiOperation("举手")
    @ResponseBody
    @PostMapping("/raise_hand_ordinary")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<Long> raiseHand(Long studentId) {
        CommandDetailDTO<RaiseHandDTO> commandDetailDTO = new CommandDetailDTO<>();
        commandDetailDTO.setCommandType(CommandTypeEnum.RAISE_HAND);
        CourseStudent courseStudent = CourseStudentLocalThread.get();
        CourseInfo courseInfo = courseInfoService.findById(courseStudent.getCourseId());
        if (courseInfo.getUsedTeacherId() == null) {
            return ResultBuilder.error(ResultCodeEnum.COURSE_NOT_START);
        }
        RaiseHandDTO raiseHandDTO = new RaiseHandDTO();
        raiseHandDTO.setMachineId(courseStudent.getMachineId());
        raiseHandDTO.setTeacherId(courseInfo.getTeacherId());
        raiseHandDTO.setStudentId(studentId);
        commandDetailDTO.setDetail(raiseHandDTO);
        commandDetailDTO.setCourseId(courseInfo.getId());
        Long id = using(CommandDTOTransfer.INSTANCE.toCommandDTO(commandDetailDTO));
        return ResultBuilder.ok(id);
    }

    @ApiOperation("举手结束")
    @ResponseBody
    @PostMapping("/raise_hand_ordinary_end")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<Long> raiseHandEnd(Long studentId) {
        CommandDetailDTO<RaiseHandDTO> commandDetailDTO = new CommandDetailDTO<>();
        commandDetailDTO.setCommandType(CommandTypeEnum.RAISE_HAND_END);
        CourseStudent courseStudent = CourseStudentLocalThread.get();
        CourseInfo courseInfo = courseInfoService.findById(courseStudent.getCourseId());
        if (courseInfo.getUsedTeacherId() == null) {
            return ResultBuilder.error(ResultCodeEnum.COURSE_NOT_START);
        }
        RaiseHandDTO raiseHandDTO = new RaiseHandDTO();
        raiseHandDTO.setMachineId(courseStudent.getMachineId());
        raiseHandDTO.setTeacherId(courseInfo.getTeacherId());
        raiseHandDTO.setStudentId(studentId);
        commandDetailDTO.setDetail(raiseHandDTO);
        commandDetailDTO.setCourseId(courseInfo.getId());
        Long id = using(CommandDTOTransfer.INSTANCE.toCommandDTO(commandDetailDTO));
        return ResultBuilder.ok(id);
    }

    public Long using(CommandDTO commandDTO) {
        CommandInfo commandInfo = CommandDTOTransfer.INSTANCE.toCommandInfo(commandDTO);
        CourseStudent courseStudent = CourseStudentLocalThread.get();
        MachineInfo machineInfo = classRoomService.findMachine(courseStudent.getMachineId());
        commandDTO.setOperationId(machineInfo.getId());
        commandDTO.setOperationName(machineInfo.getSn());


        commandInfo.setOperationId(machineInfo.getId());
        commandInfo.setOperationName(machineInfo.getSn());
        commandInfo.setSn(StringUtils.uuid());
        commandInfo.setDirection(DirectionEnum.TO_TEACHER.getValue());
        commandInfo.setCommandType(commandDTO.getCommandType().getValue());
        commandInfo.setContent(commandDTO.getContent());
        commandInfo.setCourseId(commandDTO.getCourseId());


        commandDTO.setDirection(DirectionEnum.TO_TEACHER);
        commandDTO.setSn(commandInfo.getSn());
        Long id = commandService.save(commandInfo);
        CommandMessageDTO commandMessageDTO = new CommandMessageDTO();
        commandMessageDTO.setSendUrl(studentConfig.getStudentUrl());
        commandMessageDTO.setToken(studentConfig.getToken());
        commandMessageDTO.setCommandDTO(commandDTO);
        commandQueueService.push(commandMessageDTO);
        return id;
    }

}
