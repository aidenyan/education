package com.jimmy.teacher.api.controller.admin;

import com.jimmy.dao.entity.CourseInfo;
import com.jimmy.dao.entity.TeacherStaffInfo;
import com.jimmy.model.vo.CoursewareDetailVO;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.enums.ResultCodeEnum;
import com.jimmy.mvc.common.model.dto.CourseInfoDTO;
import com.jimmy.mvc.common.model.dto.CoursewareDetailDTO;
import com.jimmy.mvc.common.model.enums.UsedStatusEnum;
import com.jimmy.mvc.common.model.transfer.CourseInfoDTOTransfer;
import com.jimmy.mvc.common.model.transfer.CoursewareDTOTransfer;
import com.jimmy.mvc.common.model.transfer.CoursewareItemDTOTransfer;
import com.jimmy.service.CourseInfoService;
import com.jimmy.service.CoursewareService;
import com.jimmy.teacher.api.controller.BaseController;
import com.jimmy.teacher.api.local.thread.TeacherLocalThread;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
public class CousewareController extends BaseController {
    public final static Integer MAX_COURSE_NUM = 100000;
    @Autowired
    private CourseInfoService courseInfoService;


    @Autowired
    private CoursewareService coursewareService;


    @ApiOperation("获取该课程的课件信息")
    @ResponseBody
    @GetMapping("/info/{courseId}")
    public Result<List<CoursewareDetailDTO>> info(@PathVariable("courseId") Long courseId) {
        List<CoursewareDetailVO> coursewareDetailVOList = coursewareService.list(courseId);
        if (CollectionUtils.isEmpty(coursewareDetailVOList)) {
            return ResultBuilder.error(ResultCodeEnum.COURSE_NOT_EXIST);
        }
        List<CoursewareDetailDTO> coursewareDetailDTOList = new ArrayList<>();
        coursewareDetailVOList.forEach(coursewareDetailVO -> {
            CoursewareDetailDTO coursewareDetailDTO = new CoursewareDetailDTO();
            coursewareDetailDTO.setCourseware(CoursewareDTOTransfer.INSTANCE.toCoursewareDTO(coursewareDetailVO.getCourseware()));
            coursewareDetailDTO.setCoursewareItemList(CoursewareItemDTOTransfer.INSTANCE.toCoursewareItemDTOList(coursewareDetailVO.getCoursewareItemList()));
            coursewareDetailDTOList.add(coursewareDetailDTO);

        });

        return ResultBuilder.error(ResultCodeEnum.OK, coursewareDetailDTOList);
    }

    @ApiOperation("获得最新的课程")
    @ResponseBody
    @GetMapping("/detail")
    public Result<CourseInfoDTO> detail() {
        TeacherStaffInfo teacherStaffInfo = TeacherLocalThread.get();
        List<CourseInfo> courseInfoList = courseInfoService.listCouldUsed(teacherStaffInfo.getAppRoomId(), teacherStaffInfo.getId(), 1);
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
        List<CourseInfo> courseInfoList = courseInfoService.listCouldUsed(teacherStaffInfo.getAppRoomId(), teacherStaffInfo.getId(), MAX_COURSE_NUM);
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
        if (courseInfo.getRoomId().equals(teacherStaffInfo.getAppRoomId())) {
            return ResultBuilder.error(ResultCodeEnum.COURSE_NOT_EXIST);
        }
        courseInfoService.useCourse(teacherStaffInfo.getId(), courseId, UsedStatusEnum.USING.getValue(), teacherStaffInfo.getAppRoomId());
        return ResultBuilder.error(ResultCodeEnum.OK);
    }

    @ApiOperation("修改课程状态改为已经使用")
    @ResponseBody
    @PostMapping("/used/{courseId}")
    public Result<Boolean> used(@PathVariable("courseId") Long courseId) {
        TeacherStaffInfo teacherStaffInfo = TeacherLocalThread.get();
        CourseInfo courseInfo = courseInfoService.findById(courseId);
        if (courseInfo == null) {
            return ResultBuilder.error(ResultCodeEnum.COURSE_NOT_EXIST);
        }
        if (courseInfo.getRoomId().equals(teacherStaffInfo.getAppRoomId())) {
            return ResultBuilder.error(ResultCodeEnum.COURSE_NOT_EXIST);
        }
        courseInfoService.useCourse(teacherStaffInfo.getId(), courseId, UsedStatusEnum.ALREADY_USED.getValue(), null);
        return ResultBuilder.error(ResultCodeEnum.OK);
    }

    @ApiOperation("修改课程状态改为未使用使用")
    @ResponseBody
    @PostMapping("/unused/{courseId}")
    public Result<Boolean> unused(@PathVariable("courseId") Long courseId) {
        TeacherStaffInfo teacherStaffInfo = TeacherLocalThread.get();
        CourseInfo courseInfo = courseInfoService.findById(courseId);
        if (courseInfo == null) {
            return ResultBuilder.error(ResultCodeEnum.COURSE_NOT_EXIST);
        }
        if (courseInfo.getRoomId().equals(teacherStaffInfo.getAppRoomId())) {
            return ResultBuilder.error(ResultCodeEnum.COURSE_NOT_EXIST);
        }
        courseInfoService.useCourse(null, courseId, UsedStatusEnum.ALREADY_USED.getValue(), null);
        return ResultBuilder.error(ResultCodeEnum.OK);
    }
}
