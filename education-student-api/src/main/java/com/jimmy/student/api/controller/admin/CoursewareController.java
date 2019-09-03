package com.jimmy.student.api.controller.admin;

import com.jimmy.dao.entity.CourseStudent;
import com.jimmy.dao.entity.Courseware;
import com.jimmy.model.vo.CoursewareDetailVO;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.enums.ResultCodeEnum;
import com.jimmy.mvc.common.model.dto.CoursewareDetailDTO;
import com.jimmy.mvc.common.model.transfer.CoursewareDTOTransfer;
import com.jimmy.mvc.common.model.transfer.CoursewareItemDTOTransfer;
import com.jimmy.service.CourseInfoService;
import com.jimmy.service.CourseStudentService;
import com.jimmy.service.CoursewareService;
import com.jimmy.student.api.controller.BaseController;
import com.jimmy.student.api.local.thread.CourseStudentLocalThread;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Api(value = "课件信息", description = "课件信息API")
@Controller
@RequestMapping("/admin/courseware")
public class CoursewareController extends BaseController {
    @Autowired
    private CourseInfoService courseInfoService;


    @Autowired
    private CoursewareService coursewareService;
    @Autowired
    private CourseStudentService courseStudentService;

    @ApiOperation("获取该课程的课件信息")
    @ResponseBody
    @GetMapping("/info")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<List<CoursewareDetailDTO>> info() {
        CourseStudent courseStudent = CourseStudentLocalThread.get();
        List<CoursewareDetailVO> coursewareDetailVOList = coursewareService.list(courseStudent.getCourseId());
        if (CollectionUtils.isEmpty(coursewareDetailVOList)) {
            return ResultBuilder.error(ResultCodeEnum.COURSE_WARE_NOT_EXIST);
        }
        List<CoursewareDetailDTO> coursewareDetailDTOList = new ArrayList<>();
        coursewareDetailVOList.forEach(coursewareDetailVO -> {
            CoursewareDetailDTO coursewareDetailDTO = new CoursewareDetailDTO();
            coursewareDetailDTO.setCourseId(courseStudent.getCourseId());
            coursewareDetailDTO.setCourseware(CoursewareDTOTransfer.INSTANCE.toCoursewareDTO(coursewareDetailVO.getCourseware()));
            coursewareDetailDTO.setCoursewareItemList(CoursewareItemDTOTransfer.INSTANCE.toCoursewareItemDTOList(coursewareDetailVO.getCoursewareItemList()));
            coursewareDetailDTOList.add(coursewareDetailDTO);

        });
        return ResultBuilder.error(ResultCodeEnum.OK, coursewareDetailDTOList);
    }

    @ApiOperation("选择课件信息")
    @ResponseBody
    @PostMapping("/select/{courewareId}")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<Void> select(@PathVariable("courewareId") Long courewareId) {
        CourseStudent courseStudent = CourseStudentLocalThread.get();
        List<Courseware> coursewareList = coursewareService.listByCourseId(courseStudent.getCourseId());
        if (CollectionUtils.isEmpty(coursewareList)) {
            return ResultBuilder.error(ResultCodeEnum.COURSE_WARE_NOT_EXIST);
        }
        Set<Long> courewareIdSet = new HashSet<>();
        coursewareList.forEach(courseware -> courewareIdSet.add(courseware.getId()));
        if (!courewareIdSet.contains(courewareId)) {
            return ResultBuilder.error(ResultCodeEnum.COURSEWARE_NOT_EXIST);
        }
        courseStudentService.updateCoursewareId(courseStudent.getId(), courewareId);
        return ResultBuilder.ok(null);
    }
}
