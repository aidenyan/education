package com.jimmy.teacher.pad.api.controller.admin;

import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.model.dto.CoursewareDetailDTO;
import com.jimmy.mvc.common.model.transfer.CoursewareDTOTransfer;
import com.jimmy.mvc.common.model.transfer.CoursewareItemDTOTransfer;
import com.jimmy.service.CoursewareService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(tags = "课程信息", description = "课程信息")
@Controller
@RequestMapping("/admin/course_ware")
public class CoursewareController {
    @Autowired
    private CoursewareService coursewareService;

    @ResponseBody
    @PostMapping("/save")
    @ApiOperation("保存课件信息信息")
    public Result<Boolean> save(CoursewareDetailDTO coursewareDetailDTO) {
        coursewareService.save(CoursewareDTOTransfer.INSTANCE.toCourseware(coursewareDetailDTO.getCourseware()),
                CoursewareItemDTOTransfer.INSTANCE.toCoursewareItemList(coursewareDetailDTO.getCoursewareItemList()),
                coursewareDetailDTO.getCourseId()
        );
        return ResultBuilder.ok(Boolean.TRUE);
    }


}
