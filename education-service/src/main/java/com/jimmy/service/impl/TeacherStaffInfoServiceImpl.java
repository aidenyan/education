package com.jimmy.service.impl;

import com.jimmy.common.utils.StringUtils;
import com.jimmy.core.local.thread.LoginLocalThread;
import com.jimmy.dao.entity.StudentInfo;
import com.jimmy.dao.entity.TeacherRoleKey;
import com.jimmy.dao.entity.TeacherStaffInfo;
import com.jimmy.dao.local.thread.SiteLocalThread;
import com.jimmy.dao.mapper.TeacherStaffInfoMapper;
import com.jimmy.service.TeacherRoleService;
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
    private TeacherRoleService teacherRoleService;

    @Autowired
    private TeacherStaffInfoMapper teacherStaffInfoMapper;


    @Override
    public TeacherStaffInfo findById(Long id) {
        Assert.notNull(id, "id is null");
        return teacherStaffInfoMapper.findById(id, SiteLocalThread.getSiteIdList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateProperty(TeacherStaffInfo teacherStaffInfo) {
        Assert.notNull(teacherStaffInfo, "teacherStaffInfo is null");
        Assert.notNull(teacherStaffInfo.getId(), "teacherStaffInfo id is null");
        teacherStaffInfo.setSiteId(SiteLocalThread.getSiteId());
        teacherStaffInfo.setModifyId(LoginLocalThread.get());
        teacherStaffInfoMapper.updateProperty(teacherStaffInfo);
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
    public void save(TeacherStaffInfo teacherStaffInfo, List<Long> roleIdList) {
        Assert.notNull(teacherStaffInfo, "teacherStaffInfo is null");
        Assert.notEmpty(roleIdList, "roleIdList is null");
        teacherStaffInfo.setSiteId(SiteLocalThread.getSiteId());
        teacherStaffInfo.setModifyId(LoginLocalThread.get());
        teacherStaffInfo.setCreateId(LoginLocalThread.get());
        teacherStaffInfo.setIsDeleted(false);
        if (teacherStaffInfo.getId() == null) {
            teacherStaffInfoMapper.insert(teacherStaffInfo);
        } else {
            teacherStaffInfoMapper.update(teacherStaffInfo);
        }
        teacherRoleService.deleted(teacherStaffInfo.getId());
        roleIdList.forEach(roleId -> {
            TeacherRoleKey teacherRoleKey = new TeacherRoleKey();
            teacherRoleKey.setRoleId(roleId);
            teacherRoleKey.setStaffId(teacherStaffInfo.getId());
            teacherRoleService.insert(teacherRoleKey);
        });

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateAppToken(Long id, String token, Long roomId) {
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
        teacherStaffInfo.setSiteId(SiteLocalThread.getSiteId());
        teacherStaffInfo.setAppRoomId(roomId);

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
        teacherStaffInfo.setSiteId(SiteLocalThread.getSiteId());
        teacherStaffInfoMapper.updateProperty(teacherStaffInfo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateHeader(String headerInfo, Long id) {
        Assert.notNull(id, "id is null");
        Assert.isTrue(StringUtils.isNotBlank(headerInfo), "headerInfo is null");
        TeacherStaffInfo teacherStaffInfo = new TeacherStaffInfo();
        teacherStaffInfo.setSiteId(SiteLocalThread.getSiteId());
        teacherStaffInfo.setModifyId(LoginLocalThread.get());
        teacherStaffInfo.setHeaderInfo(headerInfo);
        teacherStaffInfo.setId(id);
        return teacherStaffInfoMapper.updateProperty(teacherStaffInfo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateHeaderImg(String headerImg, Long id) {
        Assert.notNull(id, "id is null");
        Assert.isTrue(StringUtils.isNotBlank(headerImg), "headerImg is null");
        TeacherStaffInfo teacherStaffInfo = new TeacherStaffInfo();
        teacherStaffInfo.setSiteId(SiteLocalThread.getSiteId());
        teacherStaffInfo.setModifyId(LoginLocalThread.get());
        teacherStaffInfo.setHeaderUrl(headerImg);
        teacherStaffInfo.setId(id);
        return teacherStaffInfoMapper.updateProperty(teacherStaffInfo);
    }

    @Override
    public int updateHeader(String headerInfo, String headerImg,Integer faceVersion, Long id) {
        Assert.notNull(id, "id is null");
        Assert.isTrue(StringUtils.isNotBlank(headerInfo), "headerInfo is null");
        Assert.notNull(faceVersion, "faceVersion is null");
        Assert.isTrue(StringUtils.isNotBlank(headerImg), "headerImg is null");
        TeacherStaffInfo teacherStaffInfo = new TeacherStaffInfo();
        teacherStaffInfo.setSiteId(SiteLocalThread.getSiteId());
        teacherStaffInfo.setModifyId(LoginLocalThread.get());
        teacherStaffInfo.setHeaderInfo(headerInfo);
        teacherStaffInfo.setHeaderUrl(headerImg);
        teacherStaffInfo.setFaceVersion(faceVersion);
        teacherStaffInfo.setId(id);
        return teacherStaffInfoMapper.updateProperty(teacherStaffInfo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleted(Long id) {
        Assert.notNull(id, "id is null");
        TeacherStaffInfo teacherStaffInfo = new TeacherStaffInfo();
        teacherStaffInfo.setSiteId(SiteLocalThread.getSiteId());
        teacherStaffInfo.setIsDeleted(true);
        teacherStaffInfo.setId(id);
        teacherStaffInfo.setModifyId(LoginLocalThread.get());
        teacherStaffInfoMapper.updateProperty(teacherStaffInfo);
    }


}
