package com.jimmy.teacher.pad.api.controller.admin;

import com.jimmy.dao.entity.TeacherStaffInfo;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.enums.ResultCodeEnum;
import com.jimmy.mvc.common.model.dto.HeaderDTO;
import com.jimmy.mvc.common.model.dto.TeacherStaffInfoDTO;
import com.jimmy.mvc.common.model.transfer.TeacherStaffInfoDTOTransfer;
import com.jimmy.service.TeacherStaffInfoService;
import com.jimmy.teacher.pad.api.local.thread.TeacherLocalThread;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: StudentController
 * @Description:
 * @author: aiden
 * @date: 2019/6/16/016.
 */

@Api(value = "老师信息", description = "老师信息")
@Controller
@RequestMapping("/admin/teacher")
public class TeacherStaffController {
    @Autowired
    private TeacherStaffInfoService teacherStaffInfoService;

    @ResponseBody
    @GetMapping("/info")
    @ApiOperation("老师信息")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<TeacherStaffInfoDTO> info() {
        TeacherStaffInfo teacherStaffInfo = TeacherLocalThread.get();
        TeacherStaffInfoDTO teacherStaffInfoDTO = TeacherStaffInfoDTOTransfer.INSTANCE.toTeacherStaffInfoDTO(teacherStaffInfo);
        return ResultBuilder.error(ResultCodeEnum.OK, teacherStaffInfoDTO);
    }

    @ResponseBody
    @PostMapping("/save/header")
    @ApiOperation("保存老师头部特征信息")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<Boolean> saveHeader(@Validated(HeaderDTO.Teacher.class) @RequestBody HeaderDTO headerDTO) {
        TeacherStaffInfo teacherStaffInfo = TeacherLocalThread.get();
        teacherStaffInfoService.updateHeader(headerDTO.getHeader(), teacherStaffInfo.getId());
        return ResultBuilder.ok(Boolean.TRUE);
    }

    @ResponseBody
    @PostMapping("/save/header_img")
    @ApiOperation("保存老师头部图片信息")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<Boolean> saveHeaderImg(@Validated(HeaderDTO.Teacher.class) @RequestBody HeaderDTO headerDTO) {
        TeacherStaffInfo teacherStaffInfo = TeacherLocalThread.get();
        teacherStaffInfoService.updateHeaderImg(headerDTO.getHeader(), teacherStaffInfo.getId());
        return ResultBuilder.ok(Boolean.TRUE);
    }
}
