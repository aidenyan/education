package com.jimmy.service;

import com.jimmy.dao.entity.RoleInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleInfoService {
    /**
     * 根据ID查找该站点下的角色
     *
     * @param id ID
     * @return 角色信息
     */
    RoleInfo findById(Long id);

    /**
     * 保存角色信息
     *
     * @param record 角色
     * @return 保存结果
     */
    int insert(RoleInfo record);


    /**
     * 删除角色信息
     *
     * @param id ID
     */
    void deleted(Long id);

    /**
     * 根据角色的名字查询角色信息
     *
     * @param roleName 角色名字
     * @return List<角色信息>
     */
    List<RoleInfo> list(@Param("roleName") String roleName);

}
