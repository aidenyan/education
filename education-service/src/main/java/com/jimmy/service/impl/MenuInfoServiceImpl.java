package com.jimmy.service.impl;

import com.jimmy.dao.entity.MenuInfo;
import com.jimmy.dao.local.thread.SiteLocalThread;
import com.jimmy.dao.mapper.MenuInfoMapper;
import com.jimmy.service.MenuInfoService;
import com.jimmy.service.TeacherRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class MenuInfoServiceImpl implements MenuInfoService {
    @Autowired
    private MenuInfoMapper menuInfoMapper;


    @Autowired
    private TeacherRoleService teacherRoleService;

    @Override
    public List<MenuInfo> listByRoleId(List<Long> roleIdList) {
        Assert.notEmpty(roleIdList, "roleIdList is null");
        return menuInfoMapper.listByRoleId(roleIdList, SiteLocalThread.getSiteIdList());
    }

    @Override
    public List<MenuInfo> list() {
        return menuInfoMapper.list(SiteLocalThread.getSiteIdList());
    }

    @Override
    public List<MenuInfo> list(Long staffId) {
        Assert.notNull(staffId, "staffId is null");
        List<Long> roleIdList = teacherRoleService.list(staffId);
        if (CollectionUtils.isEmpty(roleIdList)) {
            return Collections.EMPTY_LIST;
        }
        return listByRoleId(roleIdList);
    }
}
