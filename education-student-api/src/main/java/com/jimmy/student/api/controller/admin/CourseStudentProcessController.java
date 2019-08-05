package com.jimmy.student.api.controller.admin;

import com.jimmy.dao.entity.CourseStudent;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.enums.ResultCodeEnum;
import com.jimmy.mvc.common.model.dto.CourseProcessDTO;
import com.jimmy.service.CourseStudentProcessService;
import com.jimmy.service.CourseStudentService;
import com.jimmy.student.api.controller.BaseController;
import com.jimmy.student.api.local.thread.CourseStudentLocalThread;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: ClassmateController
 * @Description:
 * @author: aiden
 * @date: 2019/7/9/009.
 */

@Api(value = "课程进程", description = "课程进程API")
@Controller
@RequestMapping("/admin/course_process")
public class CourseStudentProcessController extends BaseController {
    @Autowired
    private CourseStudentService courseStudentService;

    @Autowired
    private CourseStudentProcessService courseStudentProcessService;


    @ResponseBody
    @PostMapping("/update")
    @ApiOperation("更新学生进程")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<Void> update(@Validated @RequestBody CourseProcessDTO courseProcessDTO) {
        CourseStudent courseStudent = CourseStudentLocalThread.get();
        List<CourseStudent> courseStudentList = courseStudentService.list(courseStudent.getCourseId(), courseStudent.getMachineId());
        if (CollectionUtils.isEmpty(courseStudentList)) {
            return ResultBuilder.error(ResultCodeEnum.MACHINE_STUDENT_NOT_EXIST);
        }
        List<Long> studentIdList = new ArrayList<>();
        courseStudentList.forEach(tempCourseStudent -> studentIdList.add(tempCourseStudent.getStudentId()));
        courseStudentProcessService.updateBatch(courseStudent.getMachineId(), courseStudent.getCourseId(), studentIdList, courseProcessDTO.getStepNum(), courseStudent.getCoursewareId(), courseProcessDTO.getCoursewareItemId(), courseProcessDTO.getCoursewareItemName());
        return ResultBuilder.ok(null);
    }


}
