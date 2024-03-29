package com.jimmy.web.api.controller.admin;


import com.jimmy.common.utils.StringUtils;
import com.jimmy.core.base.Page;
import com.jimmy.dao.entity.TeacherStaffInfo;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.model.dto.TeacherStaffInfoDTO;
import com.jimmy.mvc.common.model.transfer.TeacherStaffInfoDTOTransfer;
import com.jimmy.service.TeacherRoleService;
import com.jimmy.service.TeacherStaffInfoService;
import com.jimmy.web.api.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "老师信息模块", description = "老师信息模块API")
@Controller
@RequestMapping("/admin/teacher")
public class TeacherController extends BaseController {

    @Autowired
    private TeacherStaffInfoService teacherStaffInfoService;
    @Autowired
    private TeacherRoleService teacherRoleService;

    @ResponseBody
    @GetMapping("/page")
    @ApiOperation("操作信息的类型")
    public Result<Page<TeacherStaffInfoDTO>> logTypeList(String teacherName, Integer pageNo, Integer pageSize) {
        this.setPage(pageNo, pageSize);
        List<TeacherStaffInfo> list = teacherStaffInfoService.list(teacherName);
        Page<TeacherStaffInfo> resultList = getPageResult(list);
        Page<TeacherStaffInfoDTO> resultPage = new Page<>();
        resultPage.setPageNo(resultList.getPageNo());
        resultPage.setPageSize(resultList.getPageSize());
        resultPage.setTotal(resultList.getTotal());
        resultPage.setTotalPage(resultList.getTotalPage());
        resultPage.setResult(TeacherStaffInfoDTOTransfer.INSTANCE.toTeacherStaffInfoDTOList(resultList.getResult()));
        return ResultBuilder.ok(resultPage);
    }

    @ResponseBody
    @PostMapping("/save")
    @ApiOperation("保存老师信息")
    public Result<Void> save(@RequestBody @Validated TeacherStaffInfoDTO teacherStaffInfoDTO) {
        teacherStaffInfoDTO.setIsEnabled(teacherStaffInfoDTO.getIsEnabled()==null?false:teacherStaffInfoDTO.getIsEnabled());
        teacherStaffInfoDTO.setStaffName(teacherStaffInfoDTO.getStaffType().getMessage());
        TeacherStaffInfo teacherStaffInfo=TeacherStaffInfoDTOTransfer.INSTANCE.toTeacherStaffInfo(teacherStaffInfoDTO);
        if(StringUtils.isNotBlank(teacherStaffInfoDTO.getNpw())){
            teacherStaffInfo.setPassword(teacherStaffInfoDTO.getNpw());
        }
        teacherStaffInfoService.save(teacherStaffInfo, teacherStaffInfoDTO.getRoleIdList());
        return ResultBuilder.ok(null);
    }

    @ResponseBody
    @GetMapping("/info")
    @ApiOperation("保存老师信息")
    public Result<TeacherStaffInfoDTO> info(Long id) {
        TeacherStaffInfoDTO teacherStaffInfoDTO = TeacherStaffInfoDTOTransfer.INSTANCE.toTeacherStaffInfoDTO(teacherStaffInfoService.findById(id));
        if (teacherStaffInfoDTO != null) {
            teacherStaffInfoDTO.setRoleIdList(teacherRoleService.list(id));
        }
        return ResultBuilder.ok(teacherStaffInfoDTO);
    }

    @ResponseBody
    @PostMapping("/deleted/{id}")
    @ApiOperation("删除老师信息")
    public Result<Void> deleted(@PathVariable("id") Long id) {
        teacherStaffInfoService.deleted(id);
        return ResultBuilder.ok(null);
    }
}
