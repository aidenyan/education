package com.jimmy.teacher.pad.api.controller.admin;

import com.jimmy.dao.entity.ClassMate;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.enums.ResultCodeEnum;
import com.jimmy.service.ClassMateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName: StudentController
 * @Description:
 * @author: aiden
 * @date: 2019/6/16/016.
 */

@Api(value = "班级信息", description = "班级信息")
@Controller
@RequestMapping("/admin/class_mate")
public class ClassMateController {
    @Autowired
    private ClassMateService classMateService;


    @ApiOperation("获取班级信息列表")
    @ResponseBody
    @GetMapping("/list")
    @ApiImplicitParams({@ApiImplicitParam(required = true, paramType = "header", value = "token", name = "token")})
    public Result<List<ClassMate>> list(String name) {
        List<ClassMate> classMateList = classMateService.list(name);
        return ResultBuilder.error(ResultCodeEnum.OK, classMateList);
    }
}
