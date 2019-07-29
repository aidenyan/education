package com.jimmy.service.impl;

import com.jimmy.core.local.thread.LoginLocalThread;
import com.jimmy.dao.entity.CourseStudentRegister;
import com.jimmy.dao.local.thread.SiteLocalThread;
import com.jimmy.dao.mapper.CourseStudentRegisterMapper;
import com.jimmy.service.CourseStudentRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @ClassName: CourseStudentRegisterServiceImpl
 * @Description:
 * @author: aiden
 * @date: 2019/6/17/017.
 */
@Service
@Transactional(readOnly = true)
public class CourseStudentRegisterServiceImpl implements CourseStudentRegisterService {

    @Autowired
    private CourseStudentRegisterMapper courseStudentRegisterMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(CourseStudentRegister register) {
        register.setSiteId(SiteLocalThread.getSiteId());
        register.setModifyId(LoginLocalThread.get());
        register.setCreateId(LoginLocalThread.get());
        courseStudentRegisterMapper.insert(register);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(List<CourseStudentRegister> registerList) {
        Assert.notNull(registerList);
        registerList.forEach(register -> save(register));

    }
}
