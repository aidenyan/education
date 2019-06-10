package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.SiteInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SiteInfoMapper {
    /**
     * 保存站点信息
     *
     * @param record 站点信息
     * @return 保存结果
     */
    int insert(SiteInfo record);

    /**
     * 根据域名查询对应的站点信息
     *
     * @param domain 域名
     * @return 站点信息
     */
    SiteInfo findByDomain(@Param("domain") String domain);

    /**
     * 查询子站点信息
     *
     * @param siteId 上级站点ID
     * @return List<站点信息>
     */
    List<SiteInfo> listChild(@Param("siteId") Long siteId);


}