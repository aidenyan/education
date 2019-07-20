package com.jimmy.service.impl;

import com.jimmy.common.utils.StringUtils;
import com.jimmy.dao.entity.AppVersion;
import com.jimmy.dao.local.thread.SiteLocalThread;
import com.jimmy.dao.mapper.AppVersionMapper;
import com.jimmy.service.AppVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
@Transactional(readOnly = true)
public class AppVersionServiceImpl implements AppVersionService {
    @Autowired
    private AppVersionMapper appVersionMapper;

    @Override
    public AppVersion find(String appName) {
        Assert.isTrue(StringUtils.isNotBlank(appName),"appName is null");
        return appVersionMapper.findByAppName(appName, SiteLocalThread.getSiteIdList());
    }
}
