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
    public void updateToken(String token, Long id) {
        Assert.notNull(id, "id is null");
        Assert.isTrue(StringUtils.isNotBlank(token), "token is null");
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setId(id);
        studentInfo.setAppToken(token);
        studentInfo.setModifyId(LoginLocalThread.get());
        studentInfoMapper.update(studentInfo);
    }
}
