package com.jimmy.service;

import com.jimmy.dao.entity.MenuInfo;

import java.util.List;

public interface MenuInfoService {
    /**
     * 根据roleId的列表查询对应的菜单
     *
     * @param roleIdList 角色列表
     * @return List<菜单>
     */
    List<MenuInfo> listByRoleId(List<Long> roleIdList);

    /**
     * 根据站点下所有的菜单
     *
     * @return List<菜单>
     */
    List<MenuInfo> list();
}
