package com.jimmy.web.api.controller.admin;

import com.jimmy.core.base.Page;
import com.jimmy.dao.entity.CourseInfo;
import com.jimmy.dao.entity.CourseStudentProcess;
import com.jimmy.dao.entity.StudentInfo;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.model.dto.CourseInfoDTO;
import com.jimmy.mvc.common.model.dto.CourseStudentProcessDTO;
import com.jimmy.mvc.common.model.dto.StudentInfoDTO;
import com.jimmy.mvc.common.model.transfer.CourseInfoDTOTransfer;
import com.jimmy.mvc.common.model.transfer.CourseStudentProcessDTOTransfer;
import com.jimmy.mvc.common.model.transfer.StudentInfoDTOTransfer;
import com.jimmy.service.CourseInfoService;
import com.jimmy.service.CourseStudentProcessService;
import com.jimmy.service.StudentInfoService;
import com.jimmy.web.api.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "课程进程", description = "课程进程API")
@Controller
@RequestMapping("/admin/courseprocess")
public class StudentProcessController extends BaseController {
    @Autowired
    private StudentInfoService studentInfoService;

    @Autowired
    private CourseStudentProcessService courseStudentProcessService;
    @Autowired
    private CourseInfoService courseInfoService;

    @ResponseBody
    @GetMapping("/page")
    @ApiOperation("课程的学生进程")
    public Result<Page<CourseStudentProcessDTO>> page( Long courseId, Integer pageNo, Integer pageSize) {
        this.setPage(pageNo, pageSize);
        List<CourseStudentProcess> courseStudentProcessList = courseStudentProcessService.list(courseId);
        Page<CourseStudentProcessDTO> resultList = getPageResult(courseStudentProcessList, target -> CourseStudentProcessDTOTransfer.INSTANCE.toCourseStudentProcessDTOList(target));
        if (CollectionUtils.isEmpty(courseStudentProcessList)) {
            return ResultBuilder.ok(resultList);
        }
        List<Long> studentIdList = new ArrayList<>();
        courseStudentProcessList.forEach(courseStudentProcess -> studentIdList.add(courseStudentProcess.getStudentId()));
        List<StudentInfo> studentList = studentInfoService.listBase(studentIdList);
        if (CollectionUtils.isEmpty(studentList)) {
            return ResultBuilder.ok(resultList);
        }
        CourseInfo courseInfo=courseInfoService.findById(courseId);
        CourseInfoDTO courseInfoDTO= CourseInfoDTOTransfer.INSTANCE.toCourseInfoDTO(courseInfo);
        Map<Long, StudentInfoDTO> studentIdMap = new HashMap<>();
        studentList.forEach(studentInfo -> studentIdMap.put(studentInfo.getId(), StudentInfoDTOTransfer.INSTANCE.toStudentInfoDTO(studentInfo)));
        resultList.getResult().forEach(courseStudentProcessDTO ->{

            courseStudentProcessDTO.setStudentInfoDTO(studentIdMap.get(courseStudentProcessDTO.getStudentId()));
            courseStudentProcessDTO.setCourseInfoDTO(courseInfoDTO);

        } );
        return ResultBuilder.ok(resultList);
    }
}
