package com.jimmy.teacher.api.controller.admin;

import com.jimmy.dao.entity.CourseStudent;
import com.jimmy.dao.entity.CourseStudentRegister;
import com.jimmy.dao.entity.StudentInfo;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.enums.ResultCodeEnum;
import com.jimmy.mvc.common.model.dto.RegisterDTO;
import com.jimmy.mvc.common.model.dto.StudentInfoDTO;
import com.jimmy.mvc.common.model.transfer.StudentInfoDTOTransfer;
import com.jimmy.service.CourseStudentRegisterService;
import com.jimmy.service.CourseStudentService;
import com.jimmy.service.StudentInfoService;
import com.jimmy.service.StudentStarInfoService;
import com.jimmy.teacher.api.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: StudentController
 * @Description:
 * @author: aiden
 * @date: 2019/6/12/012.
 */
@Api(tags = "学生信息相关接口", description = "学生信息相关接口API")
@Controller
@RequestMapping("/admin/student")
public class StudentController extends BaseController {
    @Autowired
    private StudentInfoService studentInfoService;

    @Autowired
    private CourseStudentService courseStudentService;

    @Autowired
    private StudentStarInfoService studentStarInfoService;

    @Autowired
    private CourseStudentRegisterService courseStudentRegisterService;

    @ApiOperation("获取本周学习之星接口")
    @ResponseBody
    @GetMapping("/star")
    public Result<List<StudentInfoDTO>> list() {
        List<StudentInfo> staffInfoDTOList = studentStarInfoService.listStar();
        return ResultBuilder.error(ResultCodeEnum.OK, StudentInfoDTOTransfer.INSTANCE.toStudentInfoDTOList(staffInfoDTOList));
    }

    @ApiOperation("获取某个机床的所有学生信息")
    @ResponseBody
    @GetMapping("/machine/list")
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
    public Result<Boolean> using(@RequestBody RegisterDTO registerDTO) {
        List<CourseStudent> courseStudentList = courseStudentService.find(registerDTO.getCourseId(), registerDTO.getStudentId(), null);
        if (CollectionUtils.isEmpty(courseStudentList)) {
            return ResultBuilder.ok(Boolean.FALSE);
        }
        List<CourseStudentRegister> registerList = new ArrayList<>();
        CourseStudentRegister courseStudentRegister;
        for (CourseStudent courseStudent : courseStudentList) {
            courseStudentRegister = new CourseStudentRegister();
            courseStudentRegister.setCommandId(registerDTO.getCommandId());
            courseStudentRegister.setIsRegister(true);
            courseStudentRegister.setCourseStudentId(courseStudent.getId());
            registerList.add(courseStudentRegister);
        }
        courseStudentRegisterService.save(registerList);
        return ResultBuilder.ok(Boolean.TRUE);
    }

    @ApiOperation("签到")
    @ResponseBody
    @PostMapping("/register/batch")
    public Result<Boolean> using(List<Long> studentIdList, Long courseId, Long commandId) {
        if (CollectionUtils.isEmpty(studentIdList)) {
            return ResultBuilder.ok(Boolean.FALSE);
        }
        List<CourseStudent> courseStudentList = courseStudentService.find(courseId, studentIdList, null);
        if (CollectionUtils.isEmpty(courseStudentList)) {
            return ResultBuilder.ok(Boolean.FALSE);
        }
        List<CourseStudentRegister> registerList = new ArrayList<>();
        CourseStudentRegister courseStudentRegister;
        for (CourseStudent courseStudent : courseStudentList) {
            courseStudentRegister = new CourseStudentRegister();
            courseStudentRegister.setCommandId(commandId);
            courseStudentRegister.setIsRegister(true);
            courseStudentRegister.setCourseStudentId(courseStudent.getId());
            registerList.add(courseStudentRegister);
        }
        courseStudentRegisterService.save(registerList);
        return ResultBuilder.ok(Boolean.TRUE);
    }
}
