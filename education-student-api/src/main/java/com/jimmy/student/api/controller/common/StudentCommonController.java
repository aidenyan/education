package com.jimmy.student.api.controller.common;

import com.alibaba.fastjson.JSON;
import com.jimmy.common.utils.EncryptUtil;
import com.jimmy.common.utils.StringUtils;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.model.dto.BroadcastDTO;
import com.jimmy.mvc.common.model.dto.CommandDTO;
import com.jimmy.mvc.common.model.dto.InteractiveDTO;
import com.jimmy.mvc.common.model.enums.CommandTypeEnum;
import com.jimmy.mvc.common.model.enums.ReceiveTypeEnum;
import com.jimmy.student.api.config.StudentConfig;
import com.jimmy.student.api.websocket.WebSocketUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * @ClassName: TeacherCommonController
 * @Description:
 * @author: aiden
 * @date: 2019/6/17/017.
 */
@Api(value = "学生部分的公共功能", description = "学部分的公共功能API")
@Controller
@RequestMapping("/student/common")
@EnableConfigurationProperties(StudentConfig.class)
public class StudentCommonController {

    @Autowired
    private StudentConfig studentConfig;

    @ApiOperation("命令接口信息")
    @ResponseBody
    @PostMapping("/command/{token}")
    public Result<Boolean> command(@RequestBody CommandDTO commandDTO, @PathVariable("token") String token) {
        if (StringUtils.isBlank(commandDTO.getSn())) {
            return ResultBuilder.ok(false);
        }
        String encryptToken = EncryptUtil.encryptMd5(commandDTO.getSn(), studentConfig.getToken());
        if (!encryptToken.equals(token)) {
            return ResultBuilder.ok(false);
        }
        /**
         * 命令相关的处理
         */
        String content = commandDTO.getContent();
        if (commandDTO.getCommandType() == CommandTypeEnum.BROADCAST_TEXT
                || commandDTO.getCommandType() == CommandTypeEnum.BROADCAST_VIDEO) {
            BroadcastDTO broadcastDTO = JSON.parseObject(content, BroadcastDTO.class);
            if (broadcastDTO == null) {
                return ResultBuilder.ok(true);
            }
            if (broadcastDTO.getReceiveType() == ReceiveTypeEnum.ALL) {
                WebSocketUtils.push(broadcastDTO.getContent(), commandDTO.getCommandType(), WebSocketUtils.listMachineId());
            } else if (broadcastDTO.getReceiveType() == ReceiveTypeEnum.USE_LIST) {
                WebSocketUtils.push(broadcastDTO.getContent(), commandDTO.getCommandType(), broadcastDTO.getMachineIdList());
            }
        } else if (commandDTO.getCommandType() == CommandTypeEnum.INTERACTIVE) {
            InteractiveDTO interactiveDTO = JSON.parseObject(content, InteractiveDTO.class);
            WebSocketUtils.push(interactiveDTO, CommandTypeEnum.INTERACTIVE, Arrays.asList(interactiveDTO.getMachineId()));
        } else if (commandDTO.getCommandType() == CommandTypeEnum.MIDDLE_SIGN_IN) {
            WebSocketUtils.push(null, commandDTO.getCommandType(), WebSocketUtils.listMachineId());
        }
        return ResultBuilder.ok(true);
    }
}
