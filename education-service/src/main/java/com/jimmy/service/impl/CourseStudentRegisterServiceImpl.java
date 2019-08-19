package com.jimmy.service.impl;

import com.jimmy.core.local.thread.LoginLocalThread;
import com.jimmy.dao.entity.CourseStudentRegister;
import com.jimmy.dao.local.thread.SiteLocalThread;
import com.jimmy.dao.mapper.CourseStudentRegisterMapper;
import com.jimmy.service.CourseStudentRegisterService;
import com.jimmy.service.TemporaryClassMateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

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
    private TemporaryClassMateService temporaryClassMateService;

    @Autowired
    private CourseStudentRegisterMapper courseStudentRegisterMapper;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(CourseStudentRegister register,Long tempClassId,Long studentId) {
        register.setSiteId(SiteLocalThread.getSiteId());
        register.setModifyId(LoginLocalThread.get());
        register.setCreateId(LoginLocalThread.get());
        courseStudentRegisterMapper.insert(register);
        temporaryClassMateService.updateRegister(studentId,register.getCommandId(),tempClassId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(List<CourseStudentRegister> registerList,Long tempClassId,Map<Long,Long> courseStudentMap) {
        Assert.notNull(registerList);
        registerList.forEach(register -> save(register,tempClassId,courseStudentMap.get(register.getCourseStudentId())));

    }
}
