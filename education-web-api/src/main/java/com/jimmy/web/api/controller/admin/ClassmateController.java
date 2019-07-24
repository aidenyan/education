package com.jimmy.web.api.controller.admin;

import com.jimmy.core.base.Page;
import com.jimmy.dao.entity.ClassMate;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.enums.ResultCodeEnum;
import com.jimmy.mvc.common.model.dto.ClassMateDTO;
import com.jimmy.mvc.common.model.transfer.ClassMateDTOTransfer;
import com.jimmy.service.ClassMateService;
import com.jimmy.service.StudentInfoService;
import com.jimmy.web.api.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: ClassmateController
 * @Description:
 * @author: aiden
 * @date: 2019/7/9/009.
 */

@Api(value = "班级信息处理", description = "班级信息处理API")
@Controller
@RequestMapping("/admin/classmate")
public class ClassmateController extends BaseController {

    @Autowired
    private ClassMateService classMateService;

    @Autowired
    private StudentInfoService studentInfoService;

    @ResponseBody
    @GetMapping("/page")
    @ApiOperation("班级信息")
    public Result<Page<ClassMateDTO>> page(String name, Integer pageNo, Integer pageSize) {
        this.setPage(pageNo, pageSize);
        List<ClassMate> list = classMateService.list(name);
        Page<ClassMateDTO> resultList = getPageResult(list, target -> ClassMateDTOTransfer.INSTANCE.toClassMateDTOList(target));
        return ResultBuilder.ok(resultList);
    }

    @ResponseBody
    @GetMapping("/detail/{id}")
    @ApiOperation("班级详细信息")
    public Result<ClassMateDTO> detail(@PathVariable("id") Long id) {
        ClassMate classMate = classMateService.findById(id);
        return ResultBuilder.ok(ClassMateDTOTransfer.INSTANCE.toClassMateDTO(classMate));
    }

    @ResponseBody
    @PostMapping("/deleted/{id}")
    @ApiOperation("班级信息")
    public Result<Void> deleted(@PathVariable("id") Long id) {
        if (!studentInfoService.isExistClassmate(id)) {
            return ResultBuilder.error(ResultCodeEnum.CLASSMATE_IS_USING);
        }
        classMateService.deleted(id);
        return ResultBuilder.ok(null);
    }

    @ResponseBody
    @PostMapping("/save")
    @ApiOperation("保存班级信息")
    public Result<Boolean> save(@Validated @RequestBody ClassMateDTO classMateDTO) {
        ClassMate classMate = ClassMateDTOTransfer.INSTANCE.toClassMate(classMateDTO);
        classMate.setIsDeleted(false);
        if (classMate.getId() == null) {
            classMateService.insert(classMate);
        } else {
            classMateService.update(classMate);
        }
        return ResultBuilder.ok(Boolean.TRUE);
    }
}
