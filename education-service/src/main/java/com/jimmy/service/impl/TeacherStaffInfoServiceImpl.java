package com.jimmy.service.impl;

import com.jimmy.common.utils.StringUtils;
import com.jimmy.core.local.thread.LoginLocalThread;
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
        return teacherStaffInfoMapper.list(name, SiteLocalThread.getSiteIdList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(TeacherStaffInfo teacherStaffInfo) {
        Assert.notNull(teacherStaffInfo, "teacherStaffInfo is null");
        teacherStaffInfo.setSiteId(SiteLocalThread.getSiteId());
        if (teacherStaffInfo.getId() == null) {
            teacherStaffInfoMapper.insert(teacherStaffInfo);
        } else {
            teacherStaffInfoMapper.update(teacherStaffInfo);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateAppToken(Long id, String token) {
        Assert.notNull(id, "id is null");
        Assert.notNull(token, "token is null");
        TeacherStaffInfo teacherStaffInfo = new TeacherStaffInfo();
        teacherStaffInfo.setId(id);
        teacherStaffInfo.setAppToken(token);
        if (LoginLocalThread.get() == null) {
            teacherStaffInfo.setModifyId(id);
        } else {
            teacherStaffInfo.setModifyId(LoginLocalThread.get());
        }
        teacherStaffInfoMapper.updateProperty(teacherStaffInfo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePadAppToken(Long id, String token) {
        Assert.notNull(id, "id is null");
        Assert.notNull(token, "token is null");
        TeacherStaffInfo teacherStaffInfo = new TeacherStaffInfo();
        teacherStaffInfo.setId(id);
        teacherStaffInfo.setPadAppToken(token);
        if (LoginLocalThread.get() == null) {
            teacherStaffInfo.setModifyId(id);
        } else {
            teacherStaffInfo.setModifyId(LoginLocalThread.get());
        }
        teacherStaffInfoMapper.updateProperty(teacherStaffInfo);
    }


}
