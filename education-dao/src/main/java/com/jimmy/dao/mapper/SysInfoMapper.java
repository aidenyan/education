package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.SysInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysInfoMapper {

    /**
     * 保存系统
     *
     * @param record 系统信息
     * @return 保存数量
     */
    int insert(SysInfo record);

    /**
     * 根据站点siteId查询系统信息
     *
     * @param siteId 站点ID
     * @return list<系统信息/>
     */

    List<SysInfo> list(@Param("siteId") Long siteId);


}