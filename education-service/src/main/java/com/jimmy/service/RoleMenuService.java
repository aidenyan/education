package com.jimmy.service;

import com.jimmy.dao.entity.RoleMenuKey;

import java.util.List;

public interface RoleMenuService {
    /**
     * 根据角色ID查找菜单ID
     *
     * @param roleId 角色ID
     * @return List<菜单ID>
     */
    List<Long> listByRoleId(Long roleId);

    /**
     * 根据角色ID查找菜单ID
     *
     * @param roleIdList 角色ID
     * @return List<菜单ID>
     */
    List<Long> listByRoleIdList(List<Long> roleIdList);

    /**
     * 删除角色与菜单的关系关系
     *
     * @param roleId 角色ID
     */
    void deleted(Long roleId);

    /**
     * 保存角色和菜单的关系信息
     *
     * @param roleMenuKey 关系信息内容
     * @return 保存结果
     */
    int insert(RoleMenuKey roleMenuKey);
}
