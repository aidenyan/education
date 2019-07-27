package com.jimmy.teacher.api.controller.admin;

import com.alibaba.fastjson.JSON;
import com.jimmy.core.enums.ResultCoreEnum;
import com.jimmy.dao.entity.*;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.enums.ResultCodeEnum;
import com.jimmy.mvc.common.model.dto.*;
import com.jimmy.mvc.common.model.enums.CommandTypeEnum;
import com.jimmy.mvc.common.model.transfer.ClassMateDTOTransfer;
import com.jimmy.mvc.common.model.transfer.CourseInfoDTOTransfer;
import com.jimmy.mvc.common.model.transfer.StudentInfoDTOTransfer;
import com.jimmy.service.*;
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

@Api(value = "重新进入的相关接口", description = "重新进入的相关接口API")
@Controller
@RequestMapping("/restart/login")
public class RestartController extends BaseController {

    @Autowired
    private CommandService commandService;

    @Autowired
    private ClassMateService classMateService;

    @Autowired
    private CourseInfoService courseInfoService;

    @Autowired
    private CourseStudentService courseStudentService;

    @Autowired
    private TemporaryClassMateService temporaryClassMateService;

    @ApiOperation("获取已经选定的课程")
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

    @ApiOperation("已经选定的班级")
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

    @ApiOperation("获取所有上课的学生")
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

    @ApiOperation("获取机床信息并且包含那些人分配")
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

    @ApiOperation("获取正在请假的信息")
    @ResponseBody
    @GetMapping("/ask_level/list")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<List<CommandStudentDTO>> listAskLevel() {
        TeacherStaffInfo teacherStaffInfo = TeacherLocalThread.get();
        CourseInfo courseInfo = courseInfoService.findByRoomId(teacherStaffInfo.getAppRoomId());
        if (courseInfo == null) {
            return ResultBuilder.error(ResultCoreEnum.RESULT_NOT_COURSE);
        }
        List<Integer> typeList = new ArrayList<>();
        typeList.add(CommandTypeEnum.ASK_LEVEL.getValue());
        typeList.add(CommandTypeEnum.ASK_LEVEL_END.getValue());
        List<CommandInfo> commandInfoList = commandService.list(courseInfo.getId(), typeList);
        if (CollectionUtils.isEmpty(commandInfoList)) {
            return ResultBuilder.ok(Collections.EMPTY_LIST);
        }
        Map<Long, CommandStudentDTO> machineIdMap = new HashMap<>();
        Map<Long, CommandStudentDTO> studentIdMap = new HashMap<>();
        commandInfoList.forEach(commandInfo -> {
            CommandStudentDTO commandStudentDTO = JSON.parseObject(commandInfo.getContent(), CommandStudentDTO.class);
            if (CommandTypeEnum.ASK_LEVEL.getValue() == commandInfo.getCommandType()) {
                machineIdMap.put(commandStudentDTO.getMachineId(), commandStudentDTO);
                if (commandStudentDTO.getStudentId() != null) {
                    studentIdMap.put(commandStudentDTO.getStudentId(), commandStudentDTO);
                }
            } else if (CommandTypeEnum.ASK_LEVEL_END.getValue() == commandInfo.getCommandType()) {
                CommandStudentDTO tempCommandStudentDTO = machineIdMap.get(commandStudentDTO.getMachineId());
                if (tempCommandStudentDTO != null) {
                    machineIdMap.remove(commandStudentDTO.getMachineId());
                }
                if (commandStudentDTO.getStudentId() != null) {
                    tempCommandStudentDTO = studentIdMap.get(commandStudentDTO.getStudentId());
                    if (tempCommandStudentDTO != null) {
                        studentIdMap.remove(commandStudentDTO.getStudentId());
                    }
                }
            }
        });
        Set<Long> machineIdSet = new HashSet<>();
        Set<Long> studentIdSet = new HashSet<>();
        List<CommandStudentDTO> resultList = new ArrayList<>();
        machineIdMap.keySet().forEach(machineId -> {
            if (!machineIdSet.contains(machineId)) {
                CommandStudentDTO tempCommanStudentDTO = machineIdMap.get(machineId);
                resultList.add(machineIdMap.get(machineId));
                if (tempCommanStudentDTO.getStudentId() != null) {
                    studentIdSet.add(tempCommanStudentDTO.getStudentId());
                }
            }
            machineIdSet.add(machineId);
        });

        studentIdMap.keySet().forEach(studentId -> {
            if (!studentIdSet.contains(studentId)) {
                resultList.add(studentIdMap.get(studentId));
            }
            studentIdSet.add(studentId);
        });
        return ResultBuilder.ok(resultList);
    }

    @ApiOperation("获取正在举手的信息")
    @ResponseBody
    @GetMapping("/raise_hand/list")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<List<CommandStudentDTO>> raiseHand() {
        TeacherStaffInfo teacherStaffInfo = TeacherLocalThread.get();
        CourseInfo courseInfo = courseInfoService.findByRoomId(teacherStaffInfo.getAppRoomId());
        if (courseInfo == null) {
            return ResultBuilder.error(ResultCoreEnum.RESULT_NOT_COURSE);
        }
        List<Integer> typeList = new ArrayList<>();
        typeList.add(CommandTypeEnum.RAISE_HAND.getValue());
        typeList.add(CommandTypeEnum.RAISE_HAND_END.getValue());
        List<CommandInfo> commandInfoList = commandService.list(courseInfo.getId(), typeList);
        if (CollectionUtils.isEmpty(commandInfoList)) {
            return ResultBuilder.ok(Collections.EMPTY_LIST);
        }
        Map<Long, CommandStudentDTO> machineIdMap = new HashMap<>();
        Map<Long, CommandStudentDTO> studentIdMap = new HashMap<>();
        commandInfoList.forEach(commandInfo -> {
            CommandStudentDTO commandStudentDTO = JSON.parseObject(commandInfo.getContent(), CommandStudentDTO.class);
            if (CommandTypeEnum.RAISE_HAND.getValue() == commandInfo.getCommandType()) {
                machineIdMap.put(commandStudentDTO.getMachineId(), commandStudentDTO);
                if (commandStudentDTO.getStudentId() != null) {
                    studentIdMap.put(commandStudentDTO.getStudentId(), commandStudentDTO);
                }
            } else if (CommandTypeEnum.RAISE_HAND_END.getValue() == commandInfo.getCommandType()) {
                CommandStudentDTO tempCommandStudentDTO = machineIdMap.get(commandStudentDTO.getMachineId());
                if (tempCommandStudentDTO != null) {
                    machineIdMap.remove(commandStudentDTO.getMachineId());
                }
                if (commandStudentDTO.getStudentId() != null) {
                    tempCommandStudentDTO = studentIdMap.get(commandStudentDTO.getStudentId());
                    if (tempCommandStudentDTO != null) {
                        studentIdMap.remove(commandStudentDTO.getStudentId());
                    }
                }
            }
        });
        Set<Long> machineIdSet = new HashSet<>();
        Set<Long> studentIdSet = new HashSet<>();
        List<CommandStudentDTO> resultList = new ArrayList<>();
        machineIdMap.keySet().forEach(machineId -> {
            if (!machineIdSet.contains(machineId)) {
                CommandStudentDTO tempCommanStudentDTO = machineIdMap.get(machineId);
                resultList.add(machineIdMap.get(machineId));
                if (tempCommanStudentDTO.getStudentId() != null) {
                    studentIdSet.add(tempCommanStudentDTO.getStudentId());
                }
            }
            machineIdSet.add(machineId);
        });

        studentIdMap.keySet().forEach(studentId -> {
            if (!studentIdSet.contains(studentId)) {
                resultList.add(studentIdMap.get(studentId));
            }
            studentIdSet.add(studentId);
        });
        return ResultBuilder.ok(resultList);
    }
}
