package com.jimmy.teacher.pad.api.controller.admin;

import com.jimmy.dao.entity.ClassMate;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.service.ClassMateService;
import io.swagger.annotations.Api;
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

@Api(tags = "�༶��Ϣ", description = "�༶��Ϣ")
@Controller
@RequestMapping("/admin/class_mate")
public class ClassMateController {
    @Autowired
    private ClassMateService classMateService;

    @ResponseBody
    @GetMapping("/list")
    @ApiOperation("�༶�б�")
    public Result<List<ClassMate>> list() {
        List<ClassMate> classMateList = classMateService.list(null);
        return ResultBuilder.ok(classMateList);
    }
}
