package com.jimmy.web.api.controller.admin;


import com.jimmy.core.base.Page;
import com.jimmy.dao.entity.TeacherStaffInfo;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.model.dto.TeacherStaffInfoDTO;
import com.jimmy.mvc.common.model.transfer.TeacherStaffInfoDTOTransfer;
import com.jimmy.service.TeacherStaffInfoService;
import com.jimmy.web.api.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "��ʦ��Ϣģ��", description = "��ʦ��Ϣģ��API")
@Controller
@RequestMapping("/admin/teacher")
public class TeacherController extends BaseController {

    @Autowired
    private TeacherStaffInfoService teacherStaffInfoService;

    @ResponseBody
    @GetMapping("/page")
    @ApiOperation("������Ϣ������")
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
    @GetMapping("/save")
    @ApiOperation("������ʦ��Ϣ")
    public Result<Void> save(@RequestBody @Validated TeacherStaffInfoDTO teacherStaffInfoDTO) {
        teacherStaffInfoService.save(TeacherStaffInfoDTOTransfer.INSTANCE.toTeacherStaffInfo(teacherStaffInfoDTO), teacherStaffInfoDTO.getRoleIdList());
        return ResultBuilder.ok(null);
    }

    @ResponseBody
    @GetMapping("/info")
    @ApiOperation("������ʦ��Ϣ")
    public Result<TeacherStaffInfoDTO> info(Long id) {
        return ResultBuilder.ok(TeacherStaffInfoDTOTransfer.INSTANCE.toTeacherStaffInfoDTO(teacherStaffInfoService.findById(id)));
    }

    @ResponseBody
    @PostMapping("/deleted/{id}")
    @ApiOperation("ɾ����ʦ��Ϣ")
    public Result<Void> deleted(@PathVariable("id") Long id) {
        teacherStaffInfoService.deleted(id);
        return ResultBuilder.ok(null);
    }
}
