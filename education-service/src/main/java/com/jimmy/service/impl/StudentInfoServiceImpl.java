package com.jimmy.service.impl;

import com.jimmy.common.utils.StringUtils;
import com.jimmy.core.local.thread.LoginLocalThread;
import com.jimmy.dao.entity.StudentInfo;
import com.jimmy.dao.local.thread.SiteLocalThread;
import com.jimmy.dao.mapper.StudentInfoMapper;
import com.jimmy.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class StudentInfoServiceImpl implements StudentInfoService {
    @Autowired
    private StudentInfoMapper studentInfoMapper;

    @Override
    public StudentInfo findById(Long id) {
        Assert.notNull(id, "id is null");
        return studentInfoMapper.findById(id, SiteLocalThread.getSiteIdList());
    }

    @Override
    public StudentInfo findByName(String name) {
        Assert.isTrue(StringUtils.isNotBlank(name), "name is null");
        return studentInfoMapper.findByName(name, SiteLocalThread.getSiteIdList());
    }

    @Override
    public List<StudentInfo> list(String name) {
        return studentInfoMapper.list(name, SiteLocalThread.getSiteIdList());
    }

    @Override
    public List<StudentInfo> list(List<Long> idList) {
        Assert.notEmpty(idList);
        return studentInfoMapper.listByIdList(idList, SiteLocalThread.getSiteIdList());
    }

    @Override
    public List<StudentInfo> listByClassMate(List<Long> classMateIdList) {
        Assert.notEmpty(classMateIdList);
        return studentInfoMapper.listByClassMate(classMateIdList,null, SiteLocalThread.getSiteIdList());
    }
    @Override
    public List<StudentInfo> listByClassMate(List<Long> classMateIdList,String realName) {
        Assert.notEmpty(classMateIdList);
        return studentInfoMapper.listByClassMate(classMateIdList,realName, SiteLocalThread.getSiteIdList());
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateToken(String token, Long id) {
        Assert.notNull(id, "id is null");
        Assert.notNull(token, "token is null");
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setId(id);
        studentInfo.setAppToken(token);
        if (LoginLocalThread.get() == null) {
            studentInfo.setModifyId(id);
        } else {
            studentInfo.setModifyId(LoginLocalThread.get());
        }
        studentInfo.setSiteId(SiteLocalThread.getSiteId());
        studentInfoMapper.updateProperty(studentInfo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int save(StudentInfo studentInfo) {
        Assert.notNull(studentInfo, "studentInfo is null");
        studentInfo.setSiteId(SiteLocalThread.getSiteId());
        studentInfo.setModifyId(LoginLocalThread.get());
        studentInfo.setCreateId(LoginLocalThread.get());
        if (studentInfo.getId() == null) {
            studentInfo.setIsDeleted(Boolean.FALSE);
            return studentInfoMapper.insert(studentInfo);
        } else {
            return studentInfoMapper.update(studentInfo);
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateHeader(String headerInfo, Long id) {
        Assert.notNull(id, "id is null");
        Assert.isTrue(StringUtils.isNotBlank(headerInfo), "headerInfo is null");
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setSiteId(SiteLocalThread.getSiteId());
        studentInfo.setModifyId(LoginLocalThread.get());
        studentInfo.setHeaderInfo(headerInfo);
        studentInfo.setId(id);
        return studentInfoMapper.updateProperty(studentInfo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateHeader(String headerInfo, String headerImg, String faceVersion,Long id) {
        Assert.notNull(id, "id is null");
        Assert.isTrue(StringUtils.isNotBlank(headerImg), "headerImg is null");
        Assert.isTrue(StringUtils.isNotBlank(headerInfo), "headerInfo is null");

        Assert.isTrue(StringUtils.isNotBlank(faceVersion), "faceVersion is null");

        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setSiteId(SiteLocalThread.getSiteId());
        studentInfo.setModifyId(LoginLocalThread.get());
        studentInfo.setHeaderUrl(headerImg);
        studentInfo.setHeaderInfo(headerInfo);
        studentInfo.setFaceVersion(faceVersion);
        studentInfo.setId(id);
         studentInfoMapper.updateProperty(studentInfo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateHeaderImg(String headerImg, Long id) {
        Assert.notNull(id, "id is null");
        Assert.isTrue(StringUtils.isNotBlank(headerImg), "headerImg is null");
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setSiteId(SiteLocalThread.getSiteId());
        studentInfo.setModifyId(LoginLocalThread.get());
        studentInfo.setHeaderUrl(headerImg);
        studentInfo.setId(id);
        return studentInfoMapper.updateProperty(studentInfo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        Assert.notNull(id, "id is null");
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setId(id);
        studentInfo.setIsDeleted(true);
        if (LoginLocalThread.get() == null) {
            studentInfo.setModifyId(id);
        } else {
            studentInfo.setModifyId(LoginLocalThread.get());
        }
        studentInfo.setSiteId(SiteLocalThread.getSiteId());
        studentInfoMapper.updateProperty(studentInfo);
    }
}
