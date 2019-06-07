package com.jimmy.service;

import com.jimmy.dao.entity.SiteInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SiteInfoService {
    /**
     * 根据域名查询对应的站点信息
     *
     * @param domain 域名
     * @return 站点信息
     */
    SiteInfo findByDomain( String domain);

    /**
     * 查询子站点信息
     *
     * @param siteId 上级站点ID
     * @return List<站点信息>
     */
    List<SiteInfo> listChild(Long siteId);
}
