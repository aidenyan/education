package com.jimmy.teacher.api.controller.admin;

import com.jimmy.core.enums.ResultCoreEnum;
import com.jimmy.dao.entity.*;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.enums.ResultCodeEnum;
import com.jimmy.mvc.common.model.dto.ClassMateDTO;
import com.jimmy.mvc.common.model.dto.CourseInfoDTO;
import com.jimmy.mvc.common.model.dto.MachineAssignDTO;
import com.jimmy.mvc.common.model.dto.StudentInfoDTO;
import com.jimmy.mvc.common.model.transfer.ClassMateDTOTransfer;
import com.jimmy.mvc.common.model.transfer.CourseInfoDTOTransfer;
import com.jimmy.mvc.common.model.transfer.StudentInfoDTOTransfer;
import com.jimmy.service.ClassMateService;
import com.jimmy.service.CourseInfoService;
import com.jimmy.service.CourseStudentService;
import com.jimmy.service.TemporaryClassMateService;
import com.jimmy.teacher.api.controller.BaseController;
import com.jimmy.teacher.api.local.thread.TeacherLocalThread;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;
import java.util.stream.Collectors;

@Api(value = "���½������ؽӿ�", description = "���½������ؽӿ�API")
@Controller
@RequestMapping("/restart/login")
public class RestartController extends BaseController {

    @Autowired
    private ClassMateService classMateService;

    @Autowired
    private CourseInfoService courseInfoService;

    @Autowired
    private CourseStudentService courseStudentService;

    @Autowired
    private TemporaryClassMateService temporaryClassMateService;

    @ApiOperation("��ȡ�Ѿ�ѡ���Ŀγ�")
    @ResponseBody
    @GetMapping("/course")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<CourseInfoDTO> getCourse() {
        TeacherStaffInfo teacherStaffInfo = TeacherLocalThread.get();
        CourseInfo courseInfo = courseInfoService.findByRoomId(teacherStaffInfo.getAppRoomId());
        if (courseInfo == null) {
            return ResultBuilder.ok(null);
        }
        return ResultBuilder.ok(CourseInfoDTOTransfer.INSTANCE.toCourseInfoDTO(courseInfo));
    }

    @ApiOperation("�Ѿ�ѡ���İ༶")
    @ResponseBody
    @GetMapping("/class_mate/list")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<List<ClassMateDTO>> listClassMate() {
        TeacherStaffInfo teacherStaffInfo = TeacherLocalThread.get();
        CourseInfo courseInfo = courseInfoService.findByRoomId(teacherStaffInfo.getAppRoomId());
        if (courseInfo == null) {
            return ResultBuilder.error(ResultCoreEnum.RESULT_NOT_COURSE);
        }
        TemporaryClassMate temporaryClassMate = temporaryClassMateService.findTempClassMate(courseInfo.getId());
        if (temporaryClassMate == null) {
            return ResultBuilder.ok(Collections.EMPTY_LIST);
        }
        List<Long> classMateIdList = temporaryClassMateService.listClassMateId(temporaryClassMate.getId());
        if (CollectionUtils.isEmpty(classMateIdList)) {
            return ResultBuilder.ok(Collections.EMPTY_LIST);
        }
        List<ClassMate> classMateList = classMateService.listById(classMateIdList);
        return ResultBuilder.ok(ClassMateDTOTransfer.INSTANCE.toClassMateDTOList(classMateList));

    }

    @ApiOperation("��ȡ�����Ͽε�ѧ��")
    @ResponseBody
    @GetMapping("/student/list")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<List<StudentInfoDTO>> listStudent() {
        TeacherStaffInfo teacherStaffInfo = TeacherLocalThread.get();
        CourseInfo courseInfo = courseInfoService.findByRoomId(teacherStaffInfo.getAppRoomId());
        if (courseInfo == null) {
            return ResultBuilder.error(ResultCoreEnum.RESULT_NOT_COURSE);
        }
        List<StudentInfo> studentInfoList = temporaryClassMateService.findStudentId(courseInfo.getId());
        return ResultBuilder.error(ResultCodeEnum.OK, StudentInfoDTOTransfer.INSTANCE.toStudentInfoDTOList(studentInfoList));
    }

    @ApiOperation("��ȡ������Ϣ���Ұ�����Щ�˷���")
    @ResponseBody
    @GetMapping("/machine/assign/list")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<List<MachineAssignDTO>> listMachineAssign() {
        TeacherStaffInfo teacherStaffInfo = TeacherLocalThread.get();
        CourseInfo courseInfo = courseInfoService.findByRoomId(teacherStaffInfo.getAppRoomId());
        if (courseInfo == null) {
            return ResultBuilder.error(ResultCoreEnum.RESULT_NOT_COURSE);
        }
        List<CourseStudent> courseStudentList = courseStudentService.list(courseInfo.getId());
        if (CollectionUtils.isEmpty(courseStudentList)) {
            return ResultBuilder.ok(Collections.EMPTY_LIST);
        }
        Map<Long, MachineAssignDTO> machineAssignDTOMap = new HashMap<>();
        courseStudentList.forEach(courseStudent -> {
            MachineAssignDTO machineAssignDTO = machineAssignDTOMap.get(courseStudent.getMachineId());
            if (machineAssignDTO == null) {
                machineAssignDTO = new MachineAssignDTO();
                machineAssignDTO.setMachineId(courseStudent.getMachineId());
                machineAssignDTOMap.put(courseStudent.getMachineId(), machineAssignDTO);
            }
            if (machineAssignDTO.getStudentIdList() == null) {
                machineAssignDTO.setStudentIdList(new ArrayList<>());
            }
            machineAssignDTO.getStudentIdList().add(courseStudent.getStudentId());

        });
        return ResultBuilder.ok(machineAssignDTOMap.values().stream().collect(Collectors.toList()));

    }
}
