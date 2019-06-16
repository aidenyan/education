package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.SysInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysInfoMapper {

    /**
     * 更新系统
     *
     * @param record 更新系统
     * @return 保存数量
     */
    int update(SysInfo record);

    /**
     * 根据站点siteId查询系统信息
     *
     * @param siteId 站点ID
     * @return list<系统信息/>
     */

    List<SysInfo> list(@Param("siteId") Long siteId);
}
