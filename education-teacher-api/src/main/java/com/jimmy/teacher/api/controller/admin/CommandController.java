package com.jimmy.teacher.api.controller.admin;

import com.alibaba.fastjson.JSON;
import com.jimmy.common.utils.StringUtils;
import com.jimmy.dao.entity.CommandInfo;
import com.jimmy.dao.entity.TeacherStaffInfo;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.model.dto.CommandDTO;
import com.jimmy.mvc.common.model.dto.CommandMessageDTO;
import com.jimmy.mvc.common.model.enums.DirectionEnum;
import com.jimmy.mvc.common.model.transfer.CommandDTOTransfer;
import com.jimmy.mvc.common.service.CommandQueueService;
import com.jimmy.service.CommandService;
import com.jimmy.teacher.api.config.TeacherConfig;
import com.jimmy.teacher.api.controller.BaseController;
import com.jimmy.teacher.api.local.thread.TeacherLocalThread;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
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
@Api(tags = "指令信息", description = "指令信息API")
@Controller
@RequestMapping("/admin/command")
@EnableConfigurationProperties(TeacherConfig.class)
public class CommandController extends BaseController {


    @Autowired
    private TeacherConfig teacherConfig;

    @Autowired
    private CommandService commandService;

    @Autowired
    private CommandQueueService commandQueueService;

    @ApiOperation("发送指令")
    @ResponseBody
    @PostMapping("/send")
    public Result<Long> using(@RequestBody CommandDTO commandDTO) {
        CommandInfo commandInfo = CommandDTOTransfer.INSTANCE.toCommandInfo(commandDTO);
        TeacherStaffInfo teacherStaffInfo = TeacherLocalThread.get();

        commandDTO.setOperationId(teacherStaffInfo.getId());
        commandDTO.setOperationName(teacherStaffInfo.getName());


        commandInfo.setOperationId(teacherStaffInfo.getId());
        commandInfo.setOperationName(teacherStaffInfo.getName());
        commandInfo.setSn(StringUtils.uuid());
        commandInfo.setDirection(DirectionEnum.TO_STUDENT.getValue());
        commandInfo.setCommandType(commandDTO.getCommandType().getValue());
        commandInfo.setContent(JSON.toJSONString(commandDTO.getContent()));
        commandInfo.setCourseId(commandDTO.getCourseId());


        commandDTO.setDirection(DirectionEnum.TO_STUDENT);
        commandDTO.setSn(commandInfo.getSn());
        Long id = commandService.save(commandInfo);
        CommandMessageDTO commandMessageDTO = new CommandMessageDTO();
        commandMessageDTO.setSendUrl(teacherConfig.getStudentUrl());
        commandMessageDTO.setToken(teacherConfig.getToken());
        commandMessageDTO.setCommandDTO(commandDTO);
        commandQueueService.push(commandMessageDTO);
        return ResultBuilder.ok(id);
    }

}
