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

import java.util.List;

@Service
@Transactional(readOnly = true)
public class AppVersionServiceImpl implements AppVersionService {
    @Autowired
    private AppVersionMapper appVersionMapper;

    @Override
    public AppVersion find(String appName) {
        Assert.isTrue(StringUtils.isNotBlank(appName), "appName is null");
        return appVersionMapper.findByAppName(appName, SiteLocalThread.getSiteIdList());
    }

    @Override
    public List<AppVersion> list(String appName) {
        return appVersionMapper.list(appName, SiteLocalThread.getSiteIdList());
    }

    @Override
    public AppVersion find(Long id) {
        Assert.notNull(id, "id is null");
        return appVersionMapper.findById(id, SiteLocalThread.getSiteIdList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(AppVersion appVersion) {
        Assert.notNull(appVersion, "id is null");
        appVersionMapper.updateProperty(appVersion);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(AppVersion appVersion) {
        Assert.notNull(appVersion, "id is null");
        appVersionMapper.insert(appVersion);
    }
}
