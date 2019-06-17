package com.jimmy.teacher.api.controller.admin;

import com.jimmy.common.utils.StringUtils;
import com.jimmy.dao.entity.CommandInfo;
import com.jimmy.dao.entity.TeacherStaffInfo;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.model.dto.CommandDTO;
import com.jimmy.mvc.common.model.enums.DirectionEnum;
import com.jimmy.mvc.common.model.transfer.CommandDTOTransfer;
import com.jimmy.service.CommandService;
import com.jimmy.teacher.api.controller.BaseController;
import com.jimmy.teacher.api.local.thread.TeacherLocalThread;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
public class CommandController extends BaseController {

    @Autowired
    private CommandService commandService;

    @ApiOperation("发送指令")
    @ResponseBody
    @PostMapping("/send")
    public Result<Long> using(@RequestBody CommandDTO commandDTO) {
        CommandInfo commandInfo = CommandDTOTransfer.INSTANCE.toCommandInfo(commandDTO);
        TeacherStaffInfo teacherStaffInfo = TeacherLocalThread.get();
        commandInfo.setOperationId(teacherStaffInfo.getId());
        commandInfo.setOperationName(teacherStaffInfo.getName());
        commandInfo.setSn(StringUtils.uuid());
        commandInfo.setDirection(DirectionEnum.TO_STUDENT.getValue());
        Long id = commandService.save(commandInfo);
        return ResultBuilder.ok(id);
    }

}
