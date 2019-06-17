package com.jimmy.student.api.controller.common;

import com.jimmy.common.utils.EncryptUtil;
import com.jimmy.common.utils.StringUtils;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.model.dto.CommandDTO;
import com.jimmy.student.api.config.StudentConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: TeacherCommonController
 * @Description:
 * @author: aiden
 * @date: 2019/6/17/017.
 */
@Api(tags = "��ʦ���ֵĹ�������", description = "��ʦ���ֵĹ�������API")
@Controller
@RequestMapping("/student/common")
@EnableConfigurationProperties(StudentConfig.class)
public class StudentCommonController {

    @Autowired
    private StudentConfig studentConfig;

    @ApiOperation("����ӿ���Ϣ")
    @ResponseBody
    @GetMapping("/command/{token}")
    public Result<Boolean> command(@RequestBody CommandDTO commandDTO, @PathVariable("token") String token) {
        if (StringUtils.isBlank(commandDTO.getSn())) {
            return ResultBuilder.ok(false);
        }
        String encryptToken = EncryptUtil.encryptMd5(commandDTO.getSn(), studentConfig.getToken());
        if (!encryptToken.equals(token)) {
            return ResultBuilder.ok(false);
        }
        /**
         * ������صĴ���
         */
        return ResultBuilder.ok(true);
    }
}
