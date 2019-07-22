package com.jimmy.teacher.api.controller.admin;

import com.jimmy.core.base.Page;
import com.jimmy.core.enums.ResultCoreEnum;
import com.jimmy.dao.entity.ClassMate;
import com.jimmy.dao.entity.CourseStudent;
import com.jimmy.dao.entity.StudentInfo;
import com.jimmy.dao.entity.TemporaryClassMate;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.enums.ResultCodeEnum;
import com.jimmy.mvc.common.model.dto.AssignMachineDTO;
import com.jimmy.mvc.common.model.dto.MachineStudentDTO;
import com.jimmy.mvc.common.model.dto.StudentInfoDTO;
import com.jimmy.mvc.common.model.dto.TempClassmateSaveDTO;
import com.jimmy.mvc.common.model.enums.CourseStatusEnum;
import com.jimmy.mvc.common.model.transfer.StudentInfoDTOTransfer;
import com.jimmy.service.ClassMateService;
import com.jimmy.service.CourseStudentService;
import com.jimmy.service.StudentInfoService;
import com.jimmy.service.TemporaryClassMateService;
import com.jimmy.teacher.api.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: ClassMateController
 * @Description:
 * @author: aiden
 * @date: 2019/6/12/012.
 */
@Api(value = "班级/临时班级信息", description = "班级/临时班级信息API")
@Controller
@RequestMapping("/admin/class_mate")
public class ClassMateController extends BaseController {

    @Autowired
    private ClassMateService classMateService;

    @Autowired
    private StudentInfoService studentInfoService;

    @Autowired
    private CourseStudentService courseStudentService;

    @Autowired
    private TemporaryClassMateService temporaryClassMateService;


    @ApiOperation("获取班级信息列表")
    @ResponseBody
    @GetMapping("/list")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<Page<ClassMate>> list(String name, Integer pageNo, Integer pageSize) {
        this.setPage(pageNo, pageSize);
        List<ClassMate> classMateList = classMateService.list(name);
        Page<ClassMate> resultList = getPageResult(classMateList);
        return ResultBuilder.ok(resultList);
    }

    @ApiOperation("根据班级获取学生的信息列表")
    @ResponseBody
    @GetMapping("/student/list")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token"),
            @ApiImplicitParam(required = true, paramType = "query", value = "班级ID", name = "classMateId")})
    public Result<List<StudentInfoDTO>> listStudent(@Validated @NotEmpty(message = "班级不能为空") Long classMateId) {
        List<StudentInfo> studentInfoList = studentInfoService.listByClassMate(Arrays.asList(classMateId));
        return ResultBuilder.error(ResultCodeEnum.OK, StudentInfoDTOTransfer.INSTANCE.toStudentInfoDTOList(studentInfoList));
    }

    @ApiOperation("通过选择的班级返回学生信息")
    @ResponseBody
    @PostMapping("/temp/student/list")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<List<StudentInfoDTO>> saveTemClass(@RequestBody @Validated TempClassmateSaveDTO tempClassmateSaveDTO) {
        TemporaryClassMate temporaryClassMate = new TemporaryClassMate();
        temporaryClassMate.setCourseId(tempClassmateSaveDTO.getCourseId());
        temporaryClassMate.setName(tempClassmateSaveDTO.getName());
        List<StudentInfo> studentInfoList = studentInfoService.listByClassMate(tempClassmateSaveDTO.getClassMateIdList());
        temporaryClassMateService.save(temporaryClassMate, studentInfoList);
        return ResultBuilder.error(ResultCodeEnum.OK, StudentInfoDTOTransfer.INSTANCE.toStudentInfoDTOList(studentInfoList));
    }

    @ApiOperation("已经选择过班级的情况下获取学生信息")
    @ResponseBody
    @GetMapping("/temp/student/list/{courseId}")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<List<StudentInfoDTO>> list(@PathVariable("courseId") Long courseId) {
        List<StudentInfo> studentInfoList = temporaryClassMateService.findStudentId(courseId);
        return ResultBuilder.error(ResultCodeEnum.OK, StudentInfoDTOTransfer.INSTANCE.toStudentInfoDTOList(studentInfoList));
    }

    @ApiOperation("分配学生和机器信息")
    @ResponseBody
    @PostMapping("/list/assign")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<Void> listAssign(@RequestBody @Validated AssignMachineDTO assignMachineDTO) {

        List<CourseStudent> courseStudentList = new ArrayList<>();
        CourseStudent courseStudent;
        for (MachineStudentDTO machineStudentDTO : assignMachineDTO.getMachineStudentsList()) {
            for (Long studentId : machineStudentDTO.getStudentIdList()) {
                courseStudent = new CourseStudent();
                courseStudent.setCourseId(assignMachineDTO.getCourseId());
                courseStudent.setStudentId(studentId);
                courseStudent.setStatus(CourseStatusEnum.ASSIGN.getValue());
                courseStudent.setMachineId(machineStudentDTO.getMachineId());
                courseStudent.setCoursewareId(machineStudentDTO.getCourewareId());
                courseStudentList.add(courseStudent);
            }
        }
        if (CollectionUtils.isEmpty(courseStudentList)) {
            return ResultBuilder.error(ResultCodeEnum.OK);
        }
        courseStudentService.save(courseStudentList);
        return ResultBuilder.error(ResultCodeEnum.OK);
    }

    @ApiOperation("单个调整学生和机器信息")
    @ResponseBody
    @PostMapping("/single/assign/{courseId}")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<Void> listAssign(@Validated @RequestBody MachineStudentDTO machineStudent, @PathVariable("courseId") Long courseId) {
        if (machineStudent == null || CollectionUtils.isEmpty(machineStudent.getStudentIdList())) {
            return ResultBuilder.error(ResultCoreEnum.RESULT_PARAMETER_EXCEPTION);
        }
        CourseStudent courseStudent;
        List<CourseStudent> courseStudentList = new ArrayList<>();
        for (Long studentId : machineStudent.getStudentIdList()) {
            courseStudent = new CourseStudent();
            courseStudent.setCourseId(courseId);
            courseStudent.setStudentId(studentId);
            courseStudent.setMachineId(machineStudent.getMachineId());
            courseStudent.setStatus(CourseStatusEnum.ASSIGN.getValue());
            courseStudent.setCoursewareId(machineStudent.getCourewareId());
            courseStudentList.add(courseStudent);
        }

        courseStudentService.save(courseStudentList);
        return ResultBuilder.error(ResultCodeEnum.OK);
    }

    @ApiOperation("获取课程已经结束的学生的ID")
    @ResponseBody
    @GetMapping("/course/list/{courseId}")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<List<Long>> listByCourseId(@PathVariable("courseId") Long courseId) {
        List<CourseStudent> courseStudentList = courseStudentService.list(courseId, CourseStatusEnum.END.getValue());
        List<Long> studentIdList = new ArrayList<>();
        if (courseStudentList == null) {
            return ResultBuilder.error(ResultCodeEnum.OK, studentIdList);
        }
        courseStudentList.forEach(courseStudent -> studentIdList.add(courseStudent.getStudentId()));
        return ResultBuilder.error(ResultCodeEnum.OK, studentIdList);
    }


}
