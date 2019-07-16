package com.jimmy.teacher.pad.api.controller.admin;

import com.jimmy.core.local.thread.LoginLocalThread;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.model.dto.CourseInfoDTO;
import com.jimmy.mvc.common.model.enums.UsedStatusEnum;
import com.jimmy.mvc.common.model.transfer.CourseInfoDTOTransfer;
import com.jimmy.service.CourseInfoService;
import com.jimmy.teacher.pad.api.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(value = "�γ���Ϣ", description = "�γ���Ϣ")
@Controller
@RequestMapping("/admin/course")
public class CourseController extends BaseController {
    @Autowired
    private CourseInfoService courseInfoService;

    @ResponseBody
    @PostMapping("/save")
    @ApiOperation("����γ���Ϣ")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<Boolean> save(@Validated @RequestBody CourseInfoDTO courseInfoDTO) {
        courseInfoDTO.setTeacherId(LoginLocalThread.get());
        courseInfoDTO.setUsedStatus(UsedStatusEnum.NOT_USED);
        courseInfoDTO.setUsedTeacherId(null);
        courseInfoService.save(CourseInfoDTOTransfer.INSTANCE.toCourseInfo(courseInfoDTO));
        return ResultBuilder.ok(Boolean.TRUE);
    }


}
