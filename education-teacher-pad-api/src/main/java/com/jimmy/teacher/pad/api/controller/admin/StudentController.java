package com.jimmy.teacher.pad.api.controller.admin;

import com.jimmy.core.enums.ResultCoreEnum;
import com.jimmy.dao.entity.StudentInfo;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.enums.ResultCodeEnum;
import com.jimmy.mvc.common.model.dto.HeaderDTO;
import com.jimmy.mvc.common.model.dto.HeaderDetailDTO;
import com.jimmy.mvc.common.model.dto.StudentInfoDTO;
import com.jimmy.mvc.common.model.transfer.StudentInfoDTOTransfer;
import com.jimmy.service.StudentInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: StudentController
 * @Description:
 * @author: aiden
 * @date: 2019/6/16/016.
 */

@Api(value = "学生信息", description = "学生信息")
@Controller
@RequestMapping("/admin/student")
public class StudentController {
    @Autowired
    private StudentInfoService studentInfoService;


    @ApiOperation("根据班级获取学生的信息列表")
    @ResponseBody
    @GetMapping("/list")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token"),
            @ApiImplicitParam(required = true, paramType = "query", value = "班级ID", name = "classMateId"),
            @ApiImplicitParam(paramType = "query", value = "真实的姓名", name = "realName")})
    public Result<List<StudentInfoDTO>> listStudent(Long classMateId, String realName) {
        if (classMateId == null) {
            return ResultBuilder.error(ResultCoreEnum.RESULT_EXCEPTION_SYS);
        }
        List<StudentInfo> studentInfoList = studentInfoService.listByClassMate(Arrays.asList(classMateId), realName);
        return ResultBuilder.error(ResultCodeEnum.OK, StudentInfoDTOTransfer.INSTANCE.toStudentInfoDTOList(studentInfoList));
    }




    @ResponseBody
    @PostMapping("/save/header_detail")
    @ApiOperation("保存学生头部详细信息")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<StudentInfoDTO> saveHeader(@Validated @RequestBody HeaderDetailDTO headerDTO) {
        studentInfoService.updateHeader(headerDTO.getHeader(), headerDTO.getHeaderImg(),headerDTO.getFaceVersion(), headerDTO.getUserId());
        return ResultBuilder.ok(StudentInfoDTOTransfer.INSTANCE.toStudentInfoDTO(studentInfoService.findById(headerDTO.getUserId())));

    }

    @ResponseBody
    @PostMapping("/save/header_img")
    @ApiOperation("保存学生头部图片信息")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<StudentInfoDTO> saveImg(@Validated(HeaderDTO.Student.class) @RequestBody HeaderDTO headerDTO) {
        studentInfoService.updateHeaderImg(headerDTO.getHeader(), headerDTO.getUserId());
        return ResultBuilder.ok(StudentInfoDTOTransfer.INSTANCE.toStudentInfoDTO(studentInfoService.findById(headerDTO.getUserId())));
    }
}
