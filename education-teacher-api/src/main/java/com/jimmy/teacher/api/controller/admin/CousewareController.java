package com.jimmy.teacher.api.controller.admin;

import com.jimmy.core.enums.ResultCoreEnum;
import com.jimmy.dao.entity.*;
import com.jimmy.model.dto.CoursewareDetailVO;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.enums.ResultCodeEnum;
import com.jimmy.mvc.common.model.dto.CourseInfoDTO;
import com.jimmy.mvc.common.model.dto.CoursewareDetailDTO;
import com.jimmy.mvc.common.model.dto.CoursewareItemDTO;
import com.jimmy.mvc.common.model.enums.ContentTypeEnum;
import com.jimmy.mvc.common.model.enums.UsedStatusEnum;
import com.jimmy.mvc.common.model.transfer.CourseInfoDTOTransfer;
import com.jimmy.mvc.common.model.transfer.CoursewareDetailDTOTransfer;
import com.jimmy.mvc.common.model.transfer.CoursewareItemDTOTransfer;
import com.jimmy.service.CourseAnswerService;
import com.jimmy.service.CourseInfoService;
import com.jimmy.service.CourseStudentService;
import com.jimmy.service.CoursewareService;
import com.jimmy.teacher.api.local.thread.TeacherLocalThread;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: CousewareController
 * @Description:
 * @author: aiden
 * @date: 2019/6/12/012.
 */
@Api(tags = "课程课件信息", description = "课程课件信息API")
@Controller
@RequestMapping("/admin/couseware")
public class CousewareController {
    public final static Integer MAX_COURSE_NUM = 100000;
    @Autowired
    private CourseInfoService courseInfoService;

    @Autowired
    private CoursewareService coursewareService;

    @Autowired
    private CourseAnswerService courseAnswerService;

    @Autowired
    private CourseStudentService courseStudentService;


    @ApiOperation("获取该课程的课件信息")
    @ResponseBody
    @GetMapping("/info/{courseId}")
    public Result<List<CoursewareDetailDTO>> info(@PathVariable("courseId") Long courseId) {
        List<CoursewareDetailVO> coursewareDetailVOList = coursewareService.list(courseId);
        if (CollectionUtils.isEmpty(coursewareDetailVOList)) {
            return ResultBuilder.error(ResultCodeEnum.COURSE_NOT_EXIST);
        }
        return ResultBuilder.error(ResultCodeEnum.OK, CoursewareDetailDTOTransfer.INSTANCE.toCoursewareDetailDTOList(coursewareDetailVOList));
    }

    @ApiOperation("获得最新的课程")
    @ResponseBody
    @GetMapping("/detail")
    public Result<CourseInfoDTO> detail() {
        TeacherStaffInfo teacherStaffInfo = TeacherLocalThread.get();
        List<CourseInfo> courseInfoList = courseInfoService.listCouldUsed(teacherStaffInfo.getRoomId(), teacherStaffInfo.getId(), 1);
        if (CollectionUtils.isEmpty(courseInfoList)) {
            return ResultBuilder.error(ResultCodeEnum.COURSE_NOT_EXIST);
        }
        return ResultBuilder.error(ResultCodeEnum.OK, CourseInfoDTOTransfer.INSTANCE.toCourseInfoDTO(courseInfoList.get(0)));
    }

    @ApiOperation("获得所有没有上过的课程")
    @ResponseBody
    @GetMapping("/list")
    public Result<List<CourseInfoDTO>> list() {
        TeacherStaffInfo teacherStaffInfo = TeacherLocalThread.get();
        List<CourseInfo> courseInfoList = courseInfoService.listCouldUsed(teacherStaffInfo.getRoomId(), teacherStaffInfo.getId(), MAX_COURSE_NUM);
        if (CollectionUtils.isEmpty(courseInfoList)) {
            return ResultBuilder.error(ResultCodeEnum.COURSE_NOT_EXIST);
        }
        return ResultBuilder.error(ResultCodeEnum.OK, CourseInfoDTOTransfer.INSTANCE.toCourseInfoDTOList(courseInfoList));
    }

    @ApiOperation("修改课程状态改为正在使用")
    @ResponseBody
    @PostMapping("/using/{courseId}")
    public Result<Boolean> using(@PathVariable("courseId") Long courseId) {
        TeacherStaffInfo teacherStaffInfo = TeacherLocalThread.get();
        CourseInfo courseInfo = courseInfoService.findById(courseId);
        if (courseInfo == null) {
            return ResultBuilder.error(ResultCodeEnum.COURSE_NOT_EXIST);
        }
        if (courseInfo.getRoomId().equals(teacherStaffInfo.getRoomId())) {
            return ResultBuilder.error(ResultCodeEnum.COURSE_NOT_EXIST);
        }
        courseInfoService.useCourse(courseId, UsedStatusEnum.USING.getValue(), teacherStaffInfo.getRoomId());
        return ResultBuilder.error(ResultCodeEnum.OK);
    }

    @ApiOperation("修改课程状态改为已经使用")
    @ResponseBody
    @PostMapping("/used/{courseId}")
    public Result<Boolean> list(@PathVariable("courseId") Long courseId) {
        TeacherStaffInfo teacherStaffInfo = TeacherLocalThread.get();
        CourseInfo courseInfo = courseInfoService.findById(courseId);
        if (courseInfo == null) {
            return ResultBuilder.error(ResultCodeEnum.COURSE_NOT_EXIST);
        }
        if (courseInfo.getRoomId().equals(teacherStaffInfo.getRoomId())) {
            return ResultBuilder.error(ResultCodeEnum.COURSE_NOT_EXIST);
        }
        courseInfoService.useCourse(courseId, UsedStatusEnum.ALREADY_USED.getValue(), null);
        return ResultBuilder.error(ResultCodeEnum.OK);
    }

    @ApiOperation("获取某个机床的图纸信息")
    @ResponseBody
    @GetMapping("/machine/courseware/{courseId}")
    public Result<List<CoursewareItemDTO>> list(@PathVariable("courseId") Long courseId, Long machineId) {
        if (machineId == null) {
            return ResultBuilder.error(ResultCoreEnum.RESULT_PARAMETER_EXCEPTION);
        }
        List<CourseStudent> courseStudentList = courseStudentService.list(courseId, machineId);
        if (CollectionUtils.isEmpty(courseStudentList)) {
            return ResultBuilder.error(ResultCodeEnum.OK);
        }
        Long courewareId = courseStudentList.get(0).getCoursewareId();
        List<CoursewareItem> itemList = coursewareService.listByCoursewareId(courewareId, ContentTypeEnum.BLUEPRINT.getValue());
        return ResultBuilder.error(ResultCodeEnum.OK, CoursewareItemDTOTransfer.INSTANCE.toCoursewareItemDTOList(itemList));
    }

    @ApiOperation("保存课件详细的图纸信息结果")
    @ResponseBody
    @PostMapping("/result/machine/courseware/{courseId}")
    public Result<Void> save(@PathVariable("courseId") Long courseId, Long machineId, Long couresewareItemId, String result) {
        if (machineId == null || couresewareItemId == null) {
            return ResultBuilder.error(ResultCoreEnum.RESULT_PARAMETER_EXCEPTION);
        }
        List<CourseStudent> courseStudentList = courseStudentService.list(courseId, machineId);
        if (CollectionUtils.isEmpty(courseStudentList)) {
            return ResultBuilder.error(ResultCoreEnum.RESULT_PARAMETER_EXCEPTION);
        }
        Long courewareId = courseStudentList.get(0).getCoursewareId();
        CourseAnswer courseAnswer = new CourseAnswer();
        courseAnswer.setTearchResult(result);
        courseAnswer.setCourseId(courseId);
        courseAnswer.setCoursewareId(courewareId);
        courseAnswer.setCoursewareItemId(couresewareItemId);
        courseAnswer.setMachineId(machineId);
        courseAnswerService.saveTearchResult(courseAnswer);
        return ResultBuilder.error(ResultCodeEnum.OK);
    }
}
