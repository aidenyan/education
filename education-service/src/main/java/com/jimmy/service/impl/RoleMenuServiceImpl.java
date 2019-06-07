package com.jimmy.service.impl;

import com.jimmy.dao.entity.RoleMenuKey;
import com.jimmy.dao.mapper.RoleMenuMapper;
import com.jimmy.service.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class RoleMenuServiceImpl implements RoleMenuService {
    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Override
    public List<Long> listByRoleId(Long roleId) {
        Assert.notNull(roleId, "roleId is null");
        return roleMenuMapper.listByRoleId(roleId);
    }

    @Override
    public List<Long> listByRoleIdList(List<Long> roleIdList) {
        Assert.notEmpty(roleIdList, "roleIdList is null");
        return roleMenuMapper.listByRoleIdList(roleIdList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleted(Long roleId) {
        Assert.notNull(roleId, "roleId is null");
        roleMenuMapper.deleted(roleId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(RoleMenuKey roleMenuKey) {
        Assert.notNull(roleMenuKey, "roleMenuKey is null");
        return roleMenuMapper.insert(roleMenuKey);
    }
}
