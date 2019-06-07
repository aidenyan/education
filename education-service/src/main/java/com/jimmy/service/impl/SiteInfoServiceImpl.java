package com.jimmy.service.impl;

import com.jimmy.dao.entity.SiteInfo;
import com.jimmy.dao.mapper.SiteInfoMapper;
import com.jimmy.service.SiteInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class SiteInfoServiceImpl implements SiteInfoService {

    @Autowired
    private SiteInfoMapper siteInfoMapper;

    public SiteInfo findByDomain(String domain) {
        return siteInfoMapper.findByDomain(domain);
    }

    @Override
    public List<SiteInfo> listChild(Long siteId) {
        return siteInfoMapper.listChild(siteId);
    }
}
