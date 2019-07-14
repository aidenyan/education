package com.jimmy.teacher.pad.api.controller.admin;

import com.jimmy.core.enums.ResultCoreEnum;
import com.jimmy.dao.entity.StudentInfo;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.enums.ResultCodeEnum;
import com.jimmy.mvc.common.model.dto.HeaderDTO;
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

@Api(value = "ѧ����Ϣ", description = "ѧ����Ϣ")
@Controller
@RequestMapping("/admin/student")
public class StudentController {
    @Autowired
    private StudentInfoService studentInfoService;


    @ApiOperation("���ݰ༶��ȡѧ������Ϣ�б�")
    @ResponseBody
    @GetMapping("/list")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token"),
            @ApiImplicitParam(required = true, paramType = "query", value = "�༶ID", name = "classMateId")})
    public Result<List<StudentInfoDTO>> listStudent(@Validated Long classMateId) {
        if (classMateId == null) {
            return ResultBuilder.error(ResultCoreEnum.RESULT_EXCEPTION_SYS);
        }
        List<StudentInfo> studentInfoList = studentInfoService.listByClassMate(Arrays.asList(classMateId));
        return ResultBuilder.error(ResultCodeEnum.OK, StudentInfoDTOTransfer.INSTANCE.toStudentInfoDTOList(studentInfoList));
    }

    @ResponseBody
    @PostMapping("/save/header_info")
    @ApiOperation("����ѧ��ͷ��������Ϣ")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<Boolean> saveHeader(@Validated(HeaderDTO.Student.class) @RequestBody HeaderDTO headerDTO) {
        studentInfoService.updateHeader(headerDTO.getHeader(), headerDTO.getUserId());
        return ResultBuilder.ok(Boolean.TRUE);
    }

    @ResponseBody
    @PostMapping("/save/header_img")
    @ApiOperation("����ѧ��ͷ��ͼƬ��Ϣ")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<Boolean> saveImg(@Validated(HeaderDTO.Student.class) @RequestBody HeaderDTO headerDTO) {
        studentInfoService.updateHeaderImg(headerDTO.getHeader(), headerDTO.getUserId());
        return ResultBuilder.ok(Boolean.TRUE);
    }
}
