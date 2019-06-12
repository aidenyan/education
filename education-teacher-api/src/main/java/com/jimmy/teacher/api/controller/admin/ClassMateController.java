package com.jimmy.teacher.api.controller.admin;

import com.jimmy.dao.entity.ClassMate;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.enums.ResultCodeEnum;
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
 * @ClassName: ClassMateController
 * @Description:
 * @author: aiden
 * @date: 2019/6/12/012.
 */
@Api(tags = "�༶/��ʱ�༶��Ϣ", description = "�γ̿μ���ϢAPI")
@Controller
@RequestMapping("/admin/class_mate")
public class ClassMateController {

    @Autowired
    private ClassMateService classMateService;


    @ApiOperation("��ȡ�༶��Ϣ�б�")
    @ResponseBody
    @GetMapping("/list")
    public Result<List<ClassMate>> list(String name) {
        List<ClassMate> classMateList = classMateService.list(name);
        return ResultBuilder.error(ResultCodeEnum.OK, classMateList);
    }


}
