package com.jimmy.student.api.controller.admin;

import com.alibaba.fastjson.JSON;
import com.jimmy.core.enums.ResultCoreEnum;
import com.jimmy.dao.entity.*;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.enums.ResultCodeEnum;
import com.jimmy.mvc.common.model.dto.CourseAnswerDTO;
import com.jimmy.mvc.common.model.dto.ListDTO;
import com.jimmy.mvc.common.model.dto.StudentInfoDTO;
import com.jimmy.mvc.common.model.dto.StudentInfoStarDTO;
import com.jimmy.mvc.common.model.transfer.StudentInfoDTOTransfer;
import com.jimmy.mvc.common.service.CommonService;
import com.jimmy.service.*;
import com.jimmy.student.api.local.thread.CourseStudentLocalThread;
import com.jimmy.student.api.local.thread.StudentLocalThread;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName: StudentController
 * @Description:
 * @author: aiden
 * @date: 2019/6/12/012.
 */
@Api(value = "学生信息相关接口", description = "学生信息相关接口API")
@Controller
@RequestMapping("/admin/student")
public class StudentController {
    @Autowired
    private StudentInfoService studentInfoService;

    @Autowired
    private CourseStudentService courseStudentService;


    @Autowired
    private CourseAnswerService courseAnswerService;

    @Autowired
    private CommonService commonService;


    @Autowired
    private TemporaryClassMateService temporaryClassMateService;

    @Autowired
    private CourseStudentRegisterService courseStudentRegisterService;

    @ApiOperation("签到")
    @ResponseBody
    @PostMapping("/register/{commandId}")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<Boolean> using(@PathVariable("commandId") Long commandId, Long studentId) {
        if (studentId == null) {
            return ResultBuilder.error(ResultCoreEnum.RESULT_PARAMETER_EXCEPTION);
        }
        CourseStudent detailCourseStudent = CourseStudentLocalThread.get();
        List<CourseStudent> courseStudentList = courseStudentService.find(detailCourseStudent.getCourseId(), detailCourseStudent.getStudentId(), null);
        if (CollectionUtils.isEmpty(courseStudentList)) {
            return ResultBuilder.ok(Boolean.FALSE);
        }
        TemporaryClassMate temporaryClassMate = temporaryClassMateService.findTempClassMate(detailCourseStudent.getCourseId());
        Map<Long, Long> studentIdMap = new HashMap<>();

        List<CourseStudentRegister> registerList = new ArrayList<>();
        CourseStudentRegister courseStudentRegister;
        for (CourseStudent courseStudent : courseStudentList) {
            if (studentId.equals(courseStudent.getCourseId())) {
                continue;
            }
            courseStudentRegister = new CourseStudentRegister();
            courseStudentRegister.setCommandId(commandId);
            courseStudentRegister.setIsRegister(true);
            courseStudentRegister.setCourseStudentId(courseStudent.getId());
            registerList.add(courseStudentRegister);
            studentIdMap.put(courseStudent.getId(), courseStudent.getStudentId());
        }
        if (CollectionUtils.isEmpty(registerList)) {
            return ResultBuilder.error(ResultCodeEnum.MACHINE_STUDENT_NOT_SAME);
        }
        courseStudentRegisterService.save(registerList, temporaryClassMate.getId(), studentIdMap);
        return ResultBuilder.ok(Boolean.TRUE);
    }

    @ApiOperation("获取学生的基本信息接口")
    @ResponseBody
    @GetMapping("/detail")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<StudentInfoDTO> detail() {
        StudentInfo studentInfo = StudentLocalThread.get();
        StudentInfoDTO studentInfoDTO = StudentInfoDTOTransfer.INSTANCE.toStudentInfoDTO(studentInfo);
        return ResultBuilder.ok(studentInfoDTO);
    }

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
    public Result<List<StudentInfoDTO>> listMachine() {
        CourseStudent courseStudent = CourseStudentLocalThread.get();
        List<CourseStudent> courseStudentList = courseStudentService.list(courseStudent.getCourseId(), courseStudent.getMachineId());
        if (CollectionUtils.isEmpty(courseStudentList)) {
            return ResultBuilder.error(ResultCodeEnum.OK);
        }
        List<Long> studentIdList = new ArrayList<>();
        courseStudentList.forEach(tempCourseStudent -> studentIdList.add(tempCourseStudent.getStudentId()));
        List<StudentInfo> studentInfoList = studentInfoService.list(studentIdList);
        return ResultBuilder.ok(StudentInfoDTOTransfer.INSTANCE.toStudentInfoDTOList(studentInfoList));
    }

    @ApiOperation("保存对图纸作品的答案")
    @ResponseBody
    @PostMapping("/answer/save/{courseId}/{machineId}")
    public Result<Boolean> save(@PathVariable("courseId") Long courseId,
                                @PathVariable("machineId") Long machineId,
                                @RequestBody ListDTO<CourseAnswerDTO> courseAnswerDTOList) {
        if (courseAnswerDTOList == null || CollectionUtils.isEmpty(courseAnswerDTOList.getResult())) {
            return ResultBuilder.error(ResultCoreEnum.RESULT_PARAMETER_EXCEPTION);
        }
        List<Long> itemIdList = new ArrayList<>();
        for (CourseAnswerDTO courseAnswerDTO : courseAnswerDTOList.getResult()) {
            itemIdList.add(courseAnswerDTO.getCoursewareItemId());
        }
        List<CourseAnswer> courseAnswerList = courseAnswerService.listMachineAnswer(courseId, machineId, itemIdList);
        if (courseAnswerList == null) {
            courseAnswerList = new ArrayList<>();
        }
        Map<Long, CourseAnswer> courseAnswerMap = new HashMap<>();
        courseAnswerList.forEach(courseAnswer -> courseAnswerMap.put(courseAnswer.getCoursewareItemId(), courseAnswer));
        for (CourseAnswerDTO courseAnswerDTO : courseAnswerDTOList.getResult()) {
            CourseAnswer courseAnswer = courseAnswerMap.get(courseAnswerDTO.getCoursewareItemId());
            if (courseAnswer == null) {
                courseAnswer = new CourseAnswer();
                courseAnswer.setMachineId(machineId);
                courseAnswer.setCoursewareId(courseAnswerDTO.getCoursewareId());
                courseAnswer.setCourseId(courseAnswerDTO.getCourseId());
                courseAnswer.setCoursewareItemId(courseAnswerDTO.getCoursewareItemId());
                courseAnswerMap.put(courseAnswerDTO.getCoursewareItemId(), courseAnswer);
            }
            courseAnswer.setCourseId(courseId);
            courseAnswer.setCoursewareId(courseAnswerDTO.getCoursewareId());
            courseAnswer.setFraction(null);
            courseAnswer.setStudentResult(JSON.toJSONString(courseAnswerDTO.getStudentResult()));
        }
        courseAnswerService.update(courseAnswerMap.values().stream().collect(Collectors.toList()));
        return ResultBuilder.ok(Boolean.TRUE);
    }
}
