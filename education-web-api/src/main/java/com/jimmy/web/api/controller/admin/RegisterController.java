package com.jimmy.web.api.controller.admin;

import com.jimmy.core.base.Page;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.model.dto.StudentDetailDTO;
import com.jimmy.mvc.common.service.CommonService;
import com.jimmy.web.api.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: StudentController
 * @Description:
 * @author: aiden
 * @date: 2019/7/11/011.
 */
@Api(value = "签到相关的信息处理", description = "签到相关的信息处理API")
@Controller
@RequestMapping("/admin/register")
public class RegisterController extends BaseController {
    @Autowired
    private CommonService commonService;

    @ResponseBody
    @GetMapping("/page/{courseId}")
    @ApiOperation("签到信息")
    public Result<Page<StudentDetailDTO>> page(@PathVariable("courseId") Long courseId, Long pageNo, Long pageSize) {
        Page<StudentDetailDTO> page = commonService.page(courseId, pageNo, pageSize);
        return ResultBuilder.ok(page);
    }


}
