package com.jimmy.teacher.pad.api.controller.admin;

import com.jimmy.common.utils.StringUtils;
import com.jimmy.core.enums.ResultCoreEnum;
import com.jimmy.dao.entity.TeacherStaffInfo;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.enums.ResultCodeEnum;
import com.jimmy.mvc.common.model.dto.TeacherStaffInfoDTO;
import com.jimmy.mvc.common.model.transfer.TeacherStaffInfoDTOTransfer;
import com.jimmy.service.TeacherStaffInfoService;
import com.jimmy.teacher.pad.api.local.thread.TeacherLocalThread;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: StudentController
 * @Description:
 * @author: aiden
 * @date: 2019/6/16/016.
 */

@Api(tags = "老师信息", description = "老师信息")
@Controller
@RequestMapping("/admin/teacher")
public class TeacherStaffController {
    @Autowired
    private TeacherStaffInfoService teacherStaffInfoService;

    @ResponseBody
    @GetMapping("/info")
    @ApiOperation("老师信息")
    public Result<TeacherStaffInfoDTO> info() {
        TeacherStaffInfo teacherStaffInfo = TeacherLocalThread.get();
        TeacherStaffInfoDTO teacherStaffInfoDTO = TeacherStaffInfoDTOTransfer.INSTANCE.toTeacherStaffInfoDTO(teacherStaffInfo);
        return ResultBuilder.error(ResultCodeEnum.OK, teacherStaffInfoDTO);
    }

    @ResponseBody
    @PostMapping("/save/header")
    @ApiOperation("保存老师头部特征信息")
    public Result<Boolean> saveHeader(String headerInfo, Long studnetId) {
        if (StringUtils.isBlank(headerInfo) || studnetId == null) {
            return ResultBuilder.error(ResultCoreEnum.RESULT_EXCEPTION_SYS);
        }
        teacherStaffInfoService.updateHeader(headerInfo, studnetId);
        return ResultBuilder.ok(Boolean.TRUE);
    }
}
