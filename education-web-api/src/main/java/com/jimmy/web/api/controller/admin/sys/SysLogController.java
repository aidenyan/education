package com.jimmy.web.api.controller.admin.sys;

import com.jimmy.web.api.controller.BaseController;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(tags = "系统信息日志模块", description = "系统信息日志模块API")
@Controller
@RequestMapping("/admin/sys/log")
public class SysLogController extends BaseController {
}
