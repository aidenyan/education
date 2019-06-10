package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.MenuInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuInfoMapper {
    /**
     * 根据roleId的列表查询对应的菜单
     *
     * @param roleIdList 角色列表
     * @return List<菜单>
     */
    List<MenuInfo> listByRoleId(@Param("roleIdList") List<Long> roleIdList, @Param("siteIdList") List<Long> siteIdList);

    /**
     * 根据站点下所有的菜单
     *
     * @param siteIdList 站点ID列表
     * @return List<菜单>
     */
    List<MenuInfo> list(@Param("siteIdList") List<Long> siteIdList);

}