package com.jimmy.service.impl;

import com.jimmy.dao.entity.MenuInfo;
import com.jimmy.dao.local.thread.SiteLocalThread;
import com.jimmy.dao.mapper.MenuInfoMapper;
import com.jimmy.service.MenuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class MenuInfoServiceImpl implements MenuInfoService {
    @Autowired
    private MenuInfoMapper menuInfoMapper;

    @Override
    public List<MenuInfo> listByRoleId(List<Long> roleIdList) {
        Assert.notEmpty(roleIdList, "roleIdList is null");
        return menuInfoMapper.listByRoleId(roleIdList, SiteLocalThread.getSiteIdList());

    }

    @Override
    public List<MenuInfo> list() {
        return menuInfoMapper.list(SiteLocalThread.getSiteIdList());
    }
}
