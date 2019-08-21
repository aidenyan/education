package com.jimmy.web.api.controller.admin;

import com.jimmy.core.base.Page;
import com.jimmy.dao.entity.MenuInfo;
import com.jimmy.dao.entity.RoleInfo;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.base.ResultBuilder;
import com.jimmy.mvc.common.model.dto.MenuDTO;
import com.jimmy.mvc.common.model.dto.RoleDTO;
import com.jimmy.mvc.common.model.dto.RoleDetailDTO;
import com.jimmy.mvc.common.model.transfer.MenuDTOTransfer;
import com.jimmy.mvc.common.model.transfer.RoleDTOTransfer;
import com.jimmy.service.MenuInfoService;
import com.jimmy.service.RoleInfoService;
import com.jimmy.service.RoleMenuService;
import com.jimmy.web.api.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: ClassmateController
 * @Description:
 * @author: aiden
 * @date: 2019/7/9/009.
 */

@Api(value = "角色", description = "角色API")
@Controller
@RequestMapping("/admin/role")
public class RoleController extends BaseController {

    @Autowired
    private MenuInfoService menuInfoService;

    @Autowired
    private RoleInfoService roleInfoService;
    @Autowired
    private RoleMenuService roleMenuService;

    @ResponseBody
    @GetMapping("/page")
    @ApiOperation("角色分页")
    public Result<Page<RoleDTO>> page(String roleName, Integer pageNo, Integer pageSize) {
        this.setPage(pageNo, pageSize);
        List<RoleInfo> roleInfoList = roleInfoService.list(roleName);
        Page<RoleDTO> resultList = getPageResult(roleInfoList, target -> RoleDTOTransfer.INSTANCE.toRoleDTOList(target));
        return ResultBuilder.ok(resultList);
    }

    @ResponseBody
    @GetMapping("/menu/list")
    @ApiOperation("菜单信息")
    public Result<List<MenuDTO>> list() {
        List<MenuInfo> menuList = menuInfoService.list();
        return ResultBuilder.ok(MenuDTOTransfer.INSTANCE.toMenuDTOList(menuList));
    }

    @ResponseBody
    @GetMapping("/detail/{id}")
    @ApiOperation("角色详细信息")
    public Result<RoleDetailDTO> detail(@PathVariable("id") Long id) {
        RoleInfo roleInfo = roleInfoService.findById(id);
        RoleDetailDTO roleDetailDTO = new RoleDetailDTO();
        roleDetailDTO.setRoleDTO(RoleDTOTransfer.INSTANCE.toRoleDTO(roleInfo));
        List<Long> menuIdList = roleMenuService.listByRoleId(id);
        roleDetailDTO.setMenuIdList(menuIdList);
        return ResultBuilder.ok(roleDetailDTO);
    }

    @ResponseBody
    @PostMapping("/save")
    @ApiOperation("角色详细信息保存")
    public Result<Long> detail(@RequestBody RoleDetailDTO roleDetailDTO) {
        RoleInfo roleInfo = RoleDTOTransfer.INSTANCE.toRoleInfo(roleDetailDTO.getRoleDTO());
        roleInfoService.save(roleInfo, roleDetailDTO.getMenuIdList());
        return ResultBuilder.ok(roleInfo.getId());
    }

    @ResponseBody
    @GetMapping("/deleted/{id}")
    @ApiOperation("删除角色")
    public Result<Boolean> deleted(@PathVariable("id") Long id) {
        roleInfoService.deleted(id);
        return ResultBuilder.ok(Boolean.TRUE);
    }
}
