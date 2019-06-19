package com.jimmy.teacher.api.controller.common;

import com.alibaba.fastjson.JSON;
import com.jimmy.common.utils.EncryptUtil;
import com.jimmy.common.utils.StringUtils;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.model.dto.CommandDTO;
import com.jimmy.mvc.common.model.dto.RaiseHandDTO;
import com.jimmy.mvc.common.model.enums.CommandTypeEnum;
import com.jimmy.teacher.api.config.TeacherConfig;
import com.jimmy.teacher.api.websocket.WebSocketUtils;
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
@Api(tags = "教师部分的公共功能", description = "教师部分的公共功能API")
@Controller
@RequestMapping("/teacher/common")
@EnableConfigurationProperties(TeacherConfig.class)
public class TeacherCommonController {

    @Autowired
    private TeacherConfig teacherConfig;

    @ApiOperation("命令接口信息")
    @ResponseBody
    @GetMapping("/command/{token}")
    public Result<Boolean> command(@RequestBody CommandDTO commandDTO, @PathVariable("token") String token) {
        if (StringUtils.isBlank(commandDTO.getSn())) {
            return ResultBuilder.ok(false);
        }
        String encryptToken = EncryptUtil.encryptMd5(commandDTO.getSn(), teacherConfig.getToken());
        if (!encryptToken.equals(token)) {
            return ResultBuilder.ok(false);
        }
        /**
         * 命令相关的处理
         */
        /**
         * 命令相关的处理
         */
        String content = JSON.toJSONString(commandDTO.getContent());
        if (commandDTO.getCommandType() == CommandTypeEnum.RAISE_HAND) {
            RaiseHandDTO raiseHandDTO = JSON.parseObject(content, RaiseHandDTO.class);
            WebSocketUtils.push(raiseHandDTO, CommandTypeEnum.INTERACTIVE, Arrays.asList(raiseHandDTO.getTeacherId()));
        }
        return ResultBuilder.ok(true);
    }
}
