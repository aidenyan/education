package com.jimmy.teacher.api.controller.admin;

import com.jimmy.dao.entity.CourseStudent;
import com.jimmy.dao.entity.CourseStudentRegister;
import com.jimmy.dao.entity.StudentInfo;
import com.jimmy.dao.entity.TemporaryClassMate;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.enums.ResultCodeEnum;
import com.jimmy.mvc.common.model.dto.RegisterBatchDTO;
import com.jimmy.mvc.common.model.dto.RegisterDTO;
import com.jimmy.mvc.common.model.dto.StudentInfoDTO;
import com.jimmy.mvc.common.model.dto.StudentInfoStarDTO;
import com.jimmy.mvc.common.model.transfer.StudentInfoDTOTransfer;
import com.jimmy.mvc.common.service.CommonService;
import com.jimmy.service.*;
import com.jimmy.teacher.api.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: StudentController
 * @Description:
 * @author: aiden
 * @date: 2019/6/12/012.
 */
@Api(value = "学生信息相关接口", description = "学生信息相关接口API")
@Controller
@RequestMapping("/admin/student")
public class StudentController extends BaseController {
    @Autowired
    private StudentInfoService studentInfoService;

    @Autowired
    private CourseStudentService courseStudentService;


    @Autowired
    private CommonService commonService;

    @Autowired
    private TemporaryClassMateService temporaryClassMateService;

    @Autowired
    private CourseStudentRegisterService courseStudentRegisterService;

    @ApiOperation("获取本周学习之星接口")
    @ResponseBody
    @GetMapping("/star")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<List<StudentInfoStarDTO>> list() {
        List<StudentInfoStarDTO> studentInfoStarDTOList = commonService.listStar();
        return ResultBuilder.ok(studentInfoStarDTOList);
    }

    @ApiOperation("获取某个机床的所有学生信息")
    @ResponseBody
    @GetMapping("/machine/list")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<List<StudentInfoDTO>> listMachine(Long courseId, Long machineId) {

        List<CourseStudent> courseStudentList = courseStudentService.list(courseId, machineId);
        if (CollectionUtils.isEmpty(courseStudentList)) {
            return ResultBuilder.ok(null);
        }
        List<Long> studentIdList = new ArrayList<>();
        courseStudentList.forEach(courseStudent -> studentIdList.add(courseStudent.getStudentId()));
        List<StudentInfo> studentInfoList = studentInfoService.list(studentIdList);
        return ResultBuilder.error(ResultCodeEnum.OK, StudentInfoDTOTransfer.INSTANCE.toStudentInfoDTOList(studentInfoList));
    }

    @ApiOperation("签到")
    @ResponseBody
    @PostMapping("/register")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<Boolean> using(@RequestBody @Validated RegisterDTO registerDTO) {
        List<CourseStudent> courseStudentList = courseStudentService.find(registerDTO.getCourseId(), registerDTO.getStudentId(), null);
        if (CollectionUtils.isEmpty(courseStudentList)) {
            return ResultBuilder.ok(Boolean.FALSE);
        }
        List<CourseStudentRegister> registerList = new ArrayList<>();
        CourseStudentRegister courseStudentRegister;
        Map<Long,Long> studentIdMap=new HashMap<>();
        for (CourseStudent courseStudent : courseStudentList) {
            courseStudentRegister = new CourseStudentRegister();
            courseStudentRegister.setCommandId(registerDTO.getCommandId());
            courseStudentRegister.setIsRegister(true);
            courseStudentRegister.setCourseStudentId(courseStudent.getId());
            registerList.add(courseStudentRegister);
            studentIdMap.put(courseStudent.getId(),courseStudent.getStudentId());
        }
        TemporaryClassMate temporaryClassMate = temporaryClassMateService.findTempClassMate(registerDTO.getCourseId());
        if (temporaryClassMate == null) {
            return ResultBuilder.error(ResultCodeEnum.STUDENT_NOT_EXIST);
        }
        courseStudentRegisterService.save(registerList, temporaryClassMate.getCourseId(),studentIdMap);
        return ResultBuilder.ok(Boolean.TRUE);
    }

    @ApiOperation("签到")
    @ResponseBody
    @PostMapping("/register/batch")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<Boolean> using(@Validated @RequestBody RegisterBatchDTO registerBatchDTO) {
        List<CourseStudent> courseStudentList = courseStudentService.find(registerBatchDTO.getCourseId(), registerBatchDTO.getStudentIdList(), null);
        if (CollectionUtils.isEmpty(courseStudentList)) {
            return ResultBuilder.ok(Boolean.FALSE);
        }
        List<CourseStudentRegister> registerList = new ArrayList<>();
        CourseStudentRegister courseStudentRegister;
        Map<Long,Long> studentIdMap=new HashMap<>();
        for (CourseStudent courseStudent : courseStudentList) {
            courseStudentRegister = new CourseStudentRegister();
            courseStudentRegister.setCommandId(registerBatchDTO.getCommandId());
            courseStudentRegister.setIsRegister(true);
            courseStudentRegister.setCourseStudentId(courseStudent.getId());
            studentIdMap.put(courseStudent.getId(),courseStudent.getStudentId());
            registerList.add(courseStudentRegister);
        }
        TemporaryClassMate temporaryClassMate = temporaryClassMateService.findTempClassMate(registerBatchDTO.getCourseId());
        if (temporaryClassMate == null) {
            return ResultBuilder.error(ResultCodeEnum.STUDENT_NOT_EXIST);
        }
        courseStudentRegisterService.save(registerList, temporaryClassMate.getCourseId(),studentIdMap);
        return ResultBuilder.ok(Boolean.TRUE);
    }
}
