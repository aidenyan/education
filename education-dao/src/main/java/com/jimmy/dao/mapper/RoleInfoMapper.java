package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.RoleInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleInfoMapper {


    /**
     * 根据ID查找该站点下的角色
     *
     * @param id ID
     * @return 角色信息
     */
    RoleInfo findById(@Param("id") Long id, @Param("siteIdList") List<Long> siteIdList);

    /**
     * 保存角色信息
     *
     * @param record 角色
     * @return 保存结果
     */
    int insert(RoleInfo record);

    /**
     * 根据角色的名字查询角色信息
     *
     * @param roleName   角色名字
     * @param siteIdList 站点ID列表
     * @return List<角色信息>
     */
    List<RoleInfo> list(@Param("roleName") String roleName, @Param("siteIdList") List<Long> siteIdList);

    /**
     * 跟新角色需要根据的数据
     *
     * @param record 角色信息
     * @return 跟新结果
     */
    int updateProperty(RoleInfo record);

    /**
     * 跟新角色的所有信息
     *
     * @param record 角色信息
     * @return 跟新结果
     */
    int update(RoleInfo record);
}