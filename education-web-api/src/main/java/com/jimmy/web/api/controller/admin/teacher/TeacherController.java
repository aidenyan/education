package com.jimmy.web.api.controller.admin.teacher;


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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Api(tags = "老师信息模块", description = "老师信息模块API")
@Controller
@RequestMapping("/admin/teacher")
public class TeacherController extends BaseController {

    @Autowired
    private TeacherStaffInfoService teacherStaffInfoService;

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
    @GetMapping("/save")
    @ApiOperation("保存老师信息")
    public Result<Void> save(TeacherStaffInfoDTO teacherStaffInfoDTO) {
        teacherStaffInfoService.save(TeacherStaffInfoDTOTransfer.INSTANCE.toTeacherStaffInfo(teacherStaffInfoDTO), teacherStaffInfoDTO.getRoleIdList());
        return ResultBuilder.ok(null);
    }
    @ResponseBody
    @GetMapping("/info")
    @ApiOperation("保存老师信息")
    public Result<TeacherStaffInfoDTO> info(Long id) {
        return ResultBuilder.ok(TeacherStaffInfoDTOTransfer.INSTANCE.toTeacherStaffInfoDTO(teacherStaffInfoService.findById(id)));
    }
}
