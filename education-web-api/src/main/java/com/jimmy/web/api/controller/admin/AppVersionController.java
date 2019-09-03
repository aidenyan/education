package com.jimmy.web.api.controller.admin;

import com.jimmy.core.base.Page;
import com.jimmy.dao.entity.AppVersion;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.service.AppVersionService;
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
@Api(value = "app相关的信息处理", description = "app相关的信息处理API")
@Controller
@RequestMapping("/admin/app/version")
public class AppVersionController extends BaseController {
    @Autowired
    private AppVersionService appVersionService;


    @ResponseBody
    @GetMapping("/page")
    @ApiOperation("app版本控制")
    public Result<Page<AppVersion>> page(String name, Integer pageNo, Integer pageSize) {
        this.setPage(pageNo, pageSize);
        List<AppVersion> list = appVersionService.list(name);
        Page<AppVersion> resultList = getPageResult(list, target -> target);
        return ResultBuilder.ok(resultList);
    }

    @ResponseBody
    @PostMapping("/save")
    @ApiOperation("保存app版本控制")
    public Result<Void> save(@Validated @RequestBody AppVersion appVersion) {
        if (appVersion.getId() == null) {
            appVersionService.save(appVersion);
        } else {
            appVersionService.update(appVersion);
        }
        return ResultBuilder.ok(null);
    }

    @ResponseBody
    @GetMapping("/info")
    @ApiOperation("查询app版本控制")
    public Result<AppVersion> info(Long id) {
        return ResultBuilder.ok(appVersionService.find(id));
    }


}
