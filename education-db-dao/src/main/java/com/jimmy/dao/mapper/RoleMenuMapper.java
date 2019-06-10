package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.RoleMenuKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMenuMapper {
    /**
     * 根据角色ID查找菜单ID
     *
     * @param roleId 角色ID
     * @return List<菜单ID>
     */
    List<Long> listByRoleId(@Param("roleId") Long roleId);
    /**
     * 根据角色ID查找菜单ID
     *
     * @param roleIdList 角色ID
     * @return List<菜单ID>
     */
    List<Long> listByRoleIdList(@Param("roleIdList") List<Long> roleIdList);
    /**
     * 删除角色与菜单的关系关系
     *
     * @param roleId 角色ID
     */
    void deleted(@Param("roleId") Long roleId);

    /**
     * 保存角色和菜单的关系信息
     *
     * @param roleMenuKey 关系信息内容
     * @return 保存结果
     */
    int insert(RoleMenuKey roleMenuKey);
}