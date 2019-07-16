package com.jimmy.teacher.api.controller.admin;

import com.jimmy.common.utils.StringUtils;
import com.jimmy.dao.entity.CommandInfo;
import com.jimmy.dao.entity.CourseInfo;
import com.jimmy.dao.entity.TeacherStaffInfo;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.enums.ResultCodeEnum;
import com.jimmy.mvc.common.model.dto.*;
import com.jimmy.mvc.common.model.enums.CommandTypeEnum;
import com.jimmy.mvc.common.model.enums.DirectionEnum;
import com.jimmy.mvc.common.model.transfer.CommandDTOTransfer;
import com.jimmy.mvc.common.service.CommandQueueService;
import com.jimmy.service.CommandService;
import com.jimmy.service.CourseInfoService;
import com.jimmy.teacher.api.config.TeacherConfig;
import com.jimmy.teacher.api.controller.BaseController;
import com.jimmy.teacher.api.local.thread.TeacherLocalThread;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: CommandController
 * @Description:
 * @author: aiden
 * @date: 2019/6/17/017.
 */
@Api(value = "ָ����Ϣ", description = "ָ����ϢAPI")
@Controller
@RequestMapping("/admin/command")
@EnableConfigurationProperties(TeacherConfig.class)
public class CommandController extends BaseController {


    @Autowired
    private TeacherConfig teacherConfig;

    @Autowired
    private CommandService commandService;

    @Autowired
    private CourseInfoService courseInfoService;

    @Autowired
    private CommandQueueService commandQueueService;

    @ApiOperation("ǩ��")
    @ResponseBody
    @PostMapping("/sing_in")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<Long> singInfo() {
        CommandDetailDTO<Void> commandDetailDTO = new CommandDetailDTO<>();
        TeacherStaffInfo teacherStaffInfo = TeacherLocalThread.get();

        CourseInfo courseInfo = courseInfoService.findByRoomId(teacherStaffInfo.getAppRoomId());
        if(courseInfo==null){
            return ResultBuilder.error(ResultCodeEnum.COURSE_NOT_START);
        }
        commandDetailDTO.setCourseId(courseInfo.getId());
        commandDetailDTO.setCommandType(CommandTypeEnum.SIGN_IN);
        Long id = using(CommandDTOTransfer.INSTANCE.toCommandDTO(commandDetailDTO));
        return ResultBuilder.ok(id);
    }

    @ApiOperation("�㲥����")
    @ResponseBody
    @PostMapping("/broadcast_text")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<Long> broadcastText(@Validated @RequestBody BroadcastDTO broadcastDTO) {
        CommandDetailDTO<BroadcastDTO> commandDetailDTO = new CommandDetailDTO<>();
        TeacherStaffInfo teacherStaffInfo = TeacherLocalThread.get();

        CourseInfo courseInfo = courseInfoService.findByRoomId(teacherStaffInfo.getAppRoomId());
        if(courseInfo==null){
            return ResultBuilder.error(ResultCodeEnum.COURSE_NOT_START);
        }
        commandDetailDTO.setCourseId(courseInfo.getId());
        commandDetailDTO.setCommandType(CommandTypeEnum.BROADCAST_TEXT);
        commandDetailDTO.setDetail(broadcastDTO);
        Long id = using(CommandDTOTransfer.INSTANCE.toCommandDTO(commandDetailDTO));
        return ResultBuilder.ok(id);
    }

    @ApiOperation("�㲥��Ƶ")
    @ResponseBody
    @PostMapping("/broadcast_video")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<Long> broadcastVideo(@Validated @RequestBody BroadcastDTO broadcastDTO) {
        CommandDetailDTO<BroadcastDTO> commandDetailDTO = new CommandDetailDTO<>();
        TeacherStaffInfo teacherStaffInfo = TeacherLocalThread.get();

        CourseInfo courseInfo = courseInfoService.findByRoomId(teacherStaffInfo.getAppRoomId());
        if(courseInfo==null){
            return ResultBuilder.error(ResultCodeEnum.COURSE_NOT_START);
        }
        commandDetailDTO.setCourseId(courseInfo.getId());
        commandDetailDTO.setCommandType(CommandTypeEnum.BROADCAST_VIDEO);
        commandDetailDTO.setDetail(broadcastDTO);
        Long id = using(CommandDTOTransfer.INSTANCE.toCommandDTO(commandDetailDTO));
        return ResultBuilder.ok(id);
    }

    @ApiOperation("����")
    @ResponseBody
    @PostMapping("/interactive")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<Long> interactive(@RequestBody @Validated InteractiveDTO interactiveDTO) {
        CommandDetailDTO<InteractiveDTO> commandDetailDTO = new CommandDetailDTO<>();
        TeacherStaffInfo teacherStaffInfo = TeacherLocalThread.get();

        CourseInfo courseInfo = courseInfoService.findByRoomId(teacherStaffInfo.getAppRoomId());
        if(courseInfo==null){
            return ResultBuilder.error(ResultCodeEnum.COURSE_NOT_START);
        }
        commandDetailDTO.setCourseId(courseInfo.getId());
        commandDetailDTO.setCommandType(CommandTypeEnum.INTERACTIVE);
        commandDetailDTO.setDetail(interactiveDTO);
        Long id = using(CommandDTOTransfer.INSTANCE.toCommandDTO(commandDetailDTO));
        return ResultBuilder.ok(id);
    }

    @ApiOperation("��;ǩ���ڸ��ԵĻ����Ͻ���ǩ��")
    @ResponseBody
    @PostMapping("/middle_sing_in")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<Long> middleSignIn() {
        CommandDetailDTO<Void> commandDetailDTO = new CommandDetailDTO<>();
        TeacherStaffInfo teacherStaffInfo = TeacherLocalThread.get();

        CourseInfo courseInfo = courseInfoService.findByRoomId(teacherStaffInfo.getAppRoomId());
        if(courseInfo==null){
            return ResultBuilder.error(ResultCodeEnum.COURSE_NOT_START);
        }
        commandDetailDTO.setCourseId(courseInfo.getId());
        commandDetailDTO.setCommandType(CommandTypeEnum.MIDDLE_SIGN_IN);
        Long id = using(CommandDTOTransfer.INSTANCE.toCommandDTO(commandDetailDTO));
        return ResultBuilder.ok(id);
    }


    public Long using(CommandDTO commandDTO) {
        CommandInfo commandInfo = CommandDTOTransfer.INSTANCE.toCommandInfo(commandDTO);
        TeacherStaffInfo teacherStaffInfo = TeacherLocalThread.get();



        commandDTO.setOperationId(teacherStaffInfo.getId());
        commandDTO.setOperationName(teacherStaffInfo.getName());


        commandInfo.setOperationId(teacherStaffInfo.getId());
        commandInfo.setOperationName(teacherStaffInfo.getName());
        commandInfo.setSn(StringUtils.uuid());
        commandInfo.setDirection(DirectionEnum.TO_STUDENT.getValue());
        commandInfo.setCommandType(commandDTO.getCommandType().getValue());
        commandInfo.setContent(commandDTO.getContent());
        commandInfo.setCourseId(commandDTO.getCourseId());


        commandDTO.setDirection(DirectionEnum.TO_STUDENT);
        commandDTO.setSn(commandInfo.getSn());

        Long id = commandService.save(commandInfo);
        CommandMessageDTO commandMessageDTO = new CommandMessageDTO();
        commandMessageDTO.setSendUrl(teacherConfig.getStudentUrl());
        commandMessageDTO.setToken(teacherConfig.getToken());
        commandMessageDTO.setCommandDTO(commandDTO);
        commandQueueService.push(commandMessageDTO);
        return id;
    }

}
