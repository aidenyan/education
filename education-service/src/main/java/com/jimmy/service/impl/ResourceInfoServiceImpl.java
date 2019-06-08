package com.jimmy.service.impl;

import com.jimmy.core.local.thread.LoginLocalThread;
import com.jimmy.dao.entity.ResourceInfo;
import com.jimmy.dao.local.thread.SiteLocalThread;
import com.jimmy.dao.mapper.ResourceInfoMapper;
import com.jimmy.service.ResourceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ResourceInfoServiceImpl implements ResourceInfoService {

    @Autowired
    private ResourceInfoMapper resourceInfoMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int save(ResourceInfo resourceInfo) {
        Assert.notNull(resourceInfo, "resourceInfo is null");
        resourceInfo.setIsDeleted(Boolean.FALSE);
        resourceInfo.setModifyId(LoginLocalThread.get());
        resourceInfo.setCreateId(LoginLocalThread.get());
        resourceInfo.setSiteId(SiteLocalThread.getSiteId());
        if (resourceInfo.getId() == null) {
            return resourceInfoMapper.insert(resourceInfo);
        } else {
            return resourceInfoMapper.update(resourceInfo);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleted(Long id) {
        Assert.notNull(id, "id is null");
        ResourceInfo resourceInfo = new ResourceInfo();
        resourceInfo.setModifyId(LoginLocalThread.get());
        resourceInfo.setSiteId(SiteLocalThread.getSiteId());
        resourceInfo.setIsDeleted(Boolean.TRUE);
        resourceInfo.setId(id);
        resourceInfoMapper.updateProperty(resourceInfo);
    }

    @Override
    public ResourceInfo findById(Long id) {
        Assert.notNull(id, "id is null");
        return resourceInfoMapper.findById(id, SiteLocalThread.getSiteIdList());
    }

    @Override
    public List<ResourceInfo> list(Integer type) {
        return resourceInfoMapper.list(type, SiteLocalThread.getSiteIdList());
    }
}
