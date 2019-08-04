package com.jimmy.web.api.controller.admin;

import com.jimmy.core.base.Page;
import com.jimmy.dao.entity.CourseInfo;
import com.jimmy.dao.entity.Courseware;
import com.jimmy.dao.entity.CoursewareItem;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.model.dto.CourseInfoDTO;
import com.jimmy.mvc.common.model.dto.CoursewareDTO;
import com.jimmy.mvc.common.model.dto.CoursewareItemDTO;
import com.jimmy.mvc.common.model.transfer.CourseInfoDTOTransfer;
import com.jimmy.mvc.common.model.transfer.CoursewareDTOTransfer;
import com.jimmy.mvc.common.model.transfer.CoursewareItemDTOTransfer;
import com.jimmy.service.CourseInfoService;
import com.jimmy.service.CoursewareService;
import com.jimmy.web.api.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName: StudentController
 * @Description:
 * @author: aiden
 * @date: 2019/7/11/011.
 */
@Api(value = "课程相关的信息处理", description = "课程相关的信息处理API")
@Controller
@RequestMapping("/admin/course")
public class CourseController extends BaseController {
    @Autowired
    private CourseInfoService courseInfoService;
    @Autowired
    private CoursewareService coursewareService;

    @ResponseBody
    @GetMapping("/page")
    @ApiOperation("学生信息")
    public Result<Page<CourseInfoDTO>> page(String name, Integer pageNo, Integer pageSize) {
        this.setPage(pageNo, pageSize);
        List<CourseInfo> list = courseInfoService.list(name);
        Page<CourseInfoDTO> resultList = getPageResult(list, target -> CourseInfoDTOTransfer.INSTANCE.toCourseInfoDTOList(target));
        return ResultBuilder.ok(resultList);
    }

    @ResponseBody
    @GetMapping("/save")
    @ApiOperation("保存课程信息")
    public Result<Void> save(@Validated @RequestBody CourseInfoDTO courseInfoDTO) {
        courseInfoService.save(CourseInfoDTOTransfer.INSTANCE.toCourseInfo(courseInfoDTO));
        return ResultBuilder.ok(null);
    }

    @ResponseBody
    @GetMapping("/info")
    @ApiOperation("查询课程信息")
    public Result<CourseInfoDTO> info(Long id) {
        return ResultBuilder.ok(CourseInfoDTOTransfer.INSTANCE.toCourseInfoDTO(courseInfoService.findById(id)));
    }

    @ResponseBody
    @GetMapping("/item_info")
    @ApiOperation("查询课件的详细信息")
    public Result<List<CoursewareItemDTO>> itemInfo(Long id) {
        List<CoursewareItem> coursewareItemsList = coursewareService.listByCoursewareId(id, null);
        return ResultBuilder.ok(CoursewareItemDTOTransfer.INSTANCE.toCoursewareItemDTOList(coursewareItemsList));
    }

    @ResponseBody
    @GetMapping("/courseware")
    @ApiOperation("查询课件")
    public Result<Page<CoursewareDTO>> list(Long id, Integer pageNo, Integer pageSize) {
        this.setPage(pageNo, pageSize);
        List<Courseware> coursewareList = coursewareService.listByCourseId(id);
        Page<CoursewareDTO> resultList = getPageResult(coursewareList, target -> CoursewareDTOTransfer.INSTANCE.toCoursewareDTOList(target));
        return ResultBuilder.ok(resultList);
    }
}
