package com.jimmy.service.impl;

import com.jimmy.core.local.thread.LoginLocalThread;
import com.jimmy.dao.entity.RoleInfo;
import com.jimmy.dao.local.thread.SiteLocalThread;
import com.jimmy.dao.mapper.RoleInfoMapper;
import com.jimmy.service.RoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class RoleInfoServiceImpl implements RoleInfoService {
    @Autowired
    private RoleInfoMapper roleInfoMapper;

    @Override
    public RoleInfo findById(Long id) {
        Assert.notNull(id, "id is null");
        return roleInfoMapper.findById(id, SiteLocalThread.getSiteIdList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(RoleInfo roleInfo) {
        Assert.notNull(roleInfo, "roleInfo is null");
        roleInfo.setDeleted(Boolean.FALSE);
        roleInfo.setModifyId(LoginLocalThread.get());
        roleInfo.setCreateId(LoginLocalThread.get());
        roleInfo.setSiteId(SiteLocalThread.getSiteId());
        if (roleInfo.getId() == null) {
            return roleInfoMapper.insert(roleInfo);
        } else {
            return roleInfoMapper.update(roleInfo);
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleted(Long id) {
        Assert.notNull(id, "id is null");
        RoleInfo roleInfo = new RoleInfo();
        roleInfo.setDeleted(Boolean.TRUE);
        roleInfo.setModifyId(LoginLocalThread.get());
        roleInfo.setId(id);
        roleInfo.setSiteId(SiteLocalThread.getSiteId());
        roleInfoMapper.updateProperty(roleInfo);
    }

    @Override
    public List<RoleInfo> list(String roleName) {
        return roleInfoMapper.list(roleName, SiteLocalThread.getSiteIdList());
    }
}
