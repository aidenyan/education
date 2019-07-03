package com.jimmy.web.api.controller.admin.common;

import com.jimmy.dao.entity.MenuInfo;
import com.jimmy.dao.entity.RoleInfo;
import com.jimmy.dao.entity.TeacherStaffInfo;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.enums.ResultCodeEnum;
import com.jimmy.mvc.common.model.dto.MenuDTO;
import com.jimmy.mvc.common.model.transfer.MenuDTOTransfer;
import com.jimmy.mvc.common.utils.PasswordUtils;
import com.jimmy.service.RoleInfoService;
import com.jimmy.service.TeacherStaffInfoService;
import com.jimmy.web.api.controller.BaseController;
import com.jimmy.web.api.dto.PasswordUpdateDTO;
import com.jimmy.web.api.local.thread.MenuInfoLocalThread;
import com.jimmy.web.api.local.thread.TeacherLocalThread;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "��Ҫ��¼�Ĺ�������", description = "��Ҫ��¼�Ĺ�������API")
@Controller
@RequestMapping("/admin/common")
public class AdminCommonController extends BaseController {

    @Autowired
    private RoleInfoService roleInfoService;

    @Autowired
    private TeacherStaffInfoService teacherStaffInfoService;

    @ResponseBody
    @GetMapping("/account/check_password")
    @ApiOperation("��鵱ǰ��¼������")
    public Result<Boolean> checkPassword(@Validated @NotEmpty(message = "���벻��Ϊ��") String password) {
        TeacherStaffInfo teacherStaffInfo = TeacherLocalThread.get();
        teacherStaffInfo = teacherStaffInfoService.findById(teacherStaffInfo.getId());
        return ResultBuilder.ok(PasswordUtils.isEquals(password, teacherStaffInfo.getPassword()));
    }

    @ResponseBody
    @GetMapping("/account/find_name")
    @ApiOperation("��ȡ�˺ŵ�����")
    public Result<String> findName() {
        TeacherStaffInfo teacherStaffInfo = TeacherLocalThread.get();
        return ResultBuilder.ok(teacherStaffInfo.getRealName());
    }

    @ResponseBody
    @GetMapping("/menu/list")
    @ApiOperation("�˵���Ϣ�б�")
    public Result<List<MenuDTO>> menuList() {
        List<MenuInfo> menuInfoList = MenuInfoLocalThread.get();

        return ResultBuilder.ok(MenuDTOTransfer.INSTANCE.toMenuDTOList(menuInfoList));
    }

    @ResponseBody
    @GetMapping("/role/list")
    @ApiOperation("��ɫ��Ϣ�б�")
    public Result<List<RoleInfo>> roleList() {
        return ResultBuilder.ok(roleInfoService.list(""));
    }

    @ResponseBody
    @PostMapping("/account/update")
    @ApiOperation("��������")
    public Result<Boolean> update(@Validated @RequestBody PasswordUpdateDTO passwordUpdate) {
        TeacherStaffInfo teacherStaffInfo = TeacherLocalThread.get();
        teacherStaffInfo = teacherStaffInfoService.findById(teacherStaffInfo.getId());
        if (!PasswordUtils.isEquals(passwordUpdate.getOldPassword(), teacherStaffInfo.getPassword())) {
            return ResultBuilder.error(ResultCodeEnum.OLD_PASSWORD_ERROR);
        }
        TeacherStaffInfo updateTeacherStaffInfo = new TeacherStaffInfo();
        updateTeacherStaffInfo.setId(updateTeacherStaffInfo.getId());
        updateTeacherStaffInfo.setRealName(passwordUpdate.getRealName());
        updateTeacherStaffInfo.setPassword(PasswordUtils.encryPassword(passwordUpdate.getPassword()));
        teacherStaffInfoService.updateProperty(updateTeacherStaffInfo);
        TeacherLocalThread.set(teacherStaffInfoService.findById(teacherStaffInfo.getId()));
        return ResultBuilder.ok(Boolean.TRUE);
    }
}
