package com.jimmy.service.impl;

import com.jimmy.common.utils.StringUtils;
import com.jimmy.dao.entity.TeacherStaffInfo;
import com.jimmy.dao.local.thread.SiteLocalThread;
import com.jimmy.dao.mapper.TeacherStaffInfoMapper;
import com.jimmy.service.TeacherStaffInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class TeacherStaffInfoServiceImpl implements TeacherStaffInfoService {
    @Autowired
    private TeacherStaffInfoMapper teacherStaffInfoMapper;

    @Override
    public TeacherStaffInfo findById(Long id) {
        Assert.notNull(id, "id is null");
        return teacherStaffInfoMapper.findById(id, SiteLocalThread.getSiteIdList());
    }

    @Override
    public TeacherStaffInfo findByName(String name) {
        Assert.isTrue(StringUtils.isNotBlank(name), "name is null");
        return teacherStaffInfoMapper.findByName(name, SiteLocalThread.getSiteIdList());
    }

    @Override
    public List<TeacherStaffInfo> list(String name) {
        Assert.isTrue(StringUtils.isNotBlank(name), "name is null");
        return teacherStaffInfoMapper.list(name, SiteLocalThread.getSiteIdList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(TeacherStaffInfo teacherStaffInfo) {
        Assert.notNull(teacherStaffInfo, "teacherStaffInfo is null");
        teacherStaffInfo.setSiteId(SiteLocalThread.getSiteId());
        return teacherStaffInfoMapper.insert(teacherStaffInfo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int update(TeacherStaffInfo teacherStaffInfo) {
        Assert.notNull(teacherStaffInfo, "teacherStaffInfo is null");
        return teacherStaffInfoMapper.update(teacherStaffInfo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateProperty(TeacherStaffInfo teacherStaffInfo) {
        Assert.notNull(teacherStaffInfo, "teacherStaffInfo is null");
        return teacherStaffInfoMapper.update(teacherStaffInfo);
    }
}
