package com.jimmy.web.api.controller.admin;

import com.jimmy.core.base.Page;
import com.jimmy.core.enums.ResultCoreEnum;
import com.jimmy.dao.entity.Courseware;
import com.jimmy.model.vo.CoursewareDetailVO;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.enums.ResultCodeEnum;
import com.jimmy.mvc.common.model.dto.CourseCoursewareDTO;
import com.jimmy.mvc.common.model.dto.CoursewareDTO;
import com.jimmy.mvc.common.model.dto.CoursewareDetailDTO;
import com.jimmy.mvc.common.model.transfer.CoursewareDTOTransfer;
import com.jimmy.mvc.common.model.transfer.CoursewareItemDTOTransfer;
import com.jimmy.service.CoursewareService;
import com.jimmy.web.api.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(value = "课件制作信息接口", description = "课件制作信息接口APi")
@Controller
@RequestMapping("/admin/course_ware")
public class CoursewareController extends BaseController {
    @Autowired
    private CoursewareService coursewareService;

    @ResponseBody
    @GetMapping("/page")
    @ApiOperation("课件信息分页信息")
    public Result<Page<CoursewareDTO>> list(String name, Integer pageNo, Integer pageSize) {
        this.setPage(pageNo, pageSize);
        List<Courseware> coursewareList = coursewareService.listByCourseName(name);
        Page<CoursewareDTO> resultList = getPageResult(coursewareList, target -> CoursewareDTOTransfer.INSTANCE.toCoursewareDTOList(target));
        return ResultBuilder.ok(resultList);
    }

    @ResponseBody
    @PostMapping("/save")
    @ApiOperation("保存课件信息信息")
    public Result<Long> save(@RequestBody @Validated CoursewareDetailDTO coursewareDetailDTO) {
        Long id = coursewareService.save(CoursewareDTOTransfer.INSTANCE.toCourseware(coursewareDetailDTO.getCourseware()),
                CoursewareItemDTOTransfer.INSTANCE.toCoursewareItemList(coursewareDetailDTO.getCoursewareItemList()),
                coursewareDetailDTO.getCourseId()
        );
        return ResultBuilder.ok(id);
    }

    @ResponseBody
    @PostMapping("/course/bind")
    @ApiOperation("绑定课程课件关系")
    public Result<Boolean> bind(@RequestBody CourseCoursewareDTO courseCoursewareDTO) {
        if (courseCoursewareDTO.getCourseId() == null || CollectionUtils.isEmpty(courseCoursewareDTO.getCoursewareIdList())) {
            ResultBuilder.error(ResultCoreEnum.RESULT_PARAMETER_EXCEPTION);
        }
        coursewareService.bind(courseCoursewareDTO.getCoursewareIdList(), courseCoursewareDTO.getCourseId());
        return ResultBuilder.ok(Boolean.TRUE);
    }

    @ResponseBody
    @PostMapping("/course/unbind")
    @ApiOperation("解绑课程课件关系")
    public Result<Boolean> unbind(@RequestBody CourseCoursewareDTO courseCoursewareDTO) {
        if (courseCoursewareDTO.getCourseId() == null || CollectionUtils.isEmpty(courseCoursewareDTO.getCoursewareIdList())) {
            ResultBuilder.error(ResultCoreEnum.RESULT_PARAMETER_EXCEPTION);
        }
        coursewareService.unBind(courseCoursewareDTO.getCoursewareIdList(), courseCoursewareDTO.getCourseId());
        return ResultBuilder.ok(Boolean.TRUE);
    }

    @ResponseBody
    @GetMapping("/course/list")
    @ApiOperation("获取该课程下所有的课件信息")
    public Result<List<CoursewareDetailDTO>> list(Long courseId) {
        if (courseId == null) {
            ResultBuilder.error(ResultCoreEnum.RESULT_PARAMETER_EXCEPTION);
        }
        List<CoursewareDetailVO> coursewareDetailVOList = coursewareService.list(courseId);
        if (CollectionUtils.isEmpty(coursewareDetailVOList)) {
            return ResultBuilder.ok(null);
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

    @ResponseBody
    @GetMapping("/courseware/find")
    @ApiOperation("获取课件信息")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<CoursewareDetailDTO> find(Long coursewareId) {
        if (coursewareId == null) {
            ResultBuilder.error(ResultCoreEnum.RESULT_PARAMETER_EXCEPTION);
        }
        CoursewareDetailVO coursewareDetailVO = coursewareService.find(coursewareId);
        if (coursewareDetailVO == null) {
            return ResultBuilder.ok(null);
        }

        CoursewareDetailDTO coursewareDetailDTO = new CoursewareDetailDTO();
        coursewareDetailDTO.setCourseware(CoursewareDTOTransfer.INSTANCE.toCoursewareDTO(coursewareDetailVO.getCourseware()));
        coursewareDetailDTO.setCoursewareItemList(CoursewareItemDTOTransfer.INSTANCE.toCoursewareItemDTOList(coursewareDetailVO.getCoursewareItemList()));
        return ResultBuilder.ok(coursewareDetailDTO);
    }
}
