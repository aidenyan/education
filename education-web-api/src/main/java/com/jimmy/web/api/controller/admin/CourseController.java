package com.jimmy.web.api.controller.admin;

import com.jimmy.core.base.Page;
import com.jimmy.dao.entity.CourseInfo;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.model.dto.CourseInfoDTO;
import com.jimmy.mvc.common.model.transfer.CourseInfoDTOTransfer;
import com.jimmy.service.CourseInfoService;
import com.jimmy.web.api.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

}
