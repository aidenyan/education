package com.jimmy.service.impl;

import com.jimmy.core.local.thread.LoginLocalThread;
import com.jimmy.dao.entity.StudentInfo;
import com.jimmy.dao.entity.TemporaryClassMate;
import com.jimmy.dao.entity.TemporaryStudentClassMate;
import com.jimmy.dao.local.thread.SiteLocalThread;
import com.jimmy.dao.mapper.TemporaryClassMateMapper;
import com.jimmy.dao.mapper.TemporaryStudentClassMateMapper;
import com.jimmy.service.StudentInfoService;
import com.jimmy.service.TemporaryClassMateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: TemporaryClassMateServiceImpl
 * @Description:
 * @author: aiden
 * @date: 2019/6/12/012.
 */
@Service
@Transactional(readOnly = true)
public class TemporaryClassMateServiceImpl implements TemporaryClassMateService {
    @Autowired
    private StudentInfoService studentInfoService;

    @Autowired
    private TemporaryClassMateMapper temporaryClassMateMapper;

    @Autowired
    private TemporaryStudentClassMateMapper temporaryStudentClassMateMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(TemporaryClassMate temporaryClassMate, List<StudentInfo> studentList) {
        Assert.notNull(temporaryClassMate);
        Assert.notNull(temporaryClassMate.getCourseId());
        TemporaryClassMate tempClass = temporaryClassMateMapper.find(temporaryClassMate.getCourseId(), SiteLocalThread.getSiteIdList());
        if (tempClass != null) {
            temporaryClassMateMapper.deleted(tempClass.getId(), SiteLocalThread.getSiteIdList());
            temporaryStudentClassMateMapper.deleted(tempClass.getId(), SiteLocalThread.getSiteIdList());
        }
        temporaryClassMate.setModifyId(LoginLocalThread.get());
        temporaryClassMate.setCreateId(LoginLocalThread.get());
        temporaryClassMate.setSiteId(SiteLocalThread.getSiteId());
        temporaryClassMateMapper.insert(temporaryClassMate);
        if (studentList == null) {
            return;
        }
        studentList.forEach(student -> {
            TemporaryStudentClassMate temporaryStudentClassMate = new TemporaryStudentClassMate();
            temporaryStudentClassMate.setClassmateId(student.getClassmateId());
            temporaryStudentClassMate.setStudentId(student.getId());
            temporaryStudentClassMate.setTemporaryClassId(temporaryClassMate.getId());
            temporaryStudentClassMate.setModifyId(LoginLocalThread.get());
            temporaryStudentClassMate.setCreateId(LoginLocalThread.get());
            temporaryStudentClassMate.setSiteId(SiteLocalThread.getSiteId());
            temporaryStudentClassMateMapper.insert(temporaryStudentClassMate);

        });
    }

    @Override
    public List<StudentInfo> findStudentId(Long courseId) {
        TemporaryClassMate tempClass = temporaryClassMateMapper.find(courseId, SiteLocalThread.getSiteIdList());
        if (tempClass == null) {
            return null;
        }
        List<TemporaryStudentClassMate> classMateList = temporaryStudentClassMateMapper.list(tempClass.getId(), SiteLocalThread.getSiteIdList());
        if (CollectionUtils.isEmpty(classMateList)) {
            return null;
        }
        List<Long> studentIdList = new ArrayList<>();
        classMateList.forEach(classMate -> studentIdList.add(classMate.getStudentId()));
        return studentInfoService.list(studentIdList);
    }

    @Override
    public TemporaryClassMate findTempClassMate(Long courseId) {
        Assert.notNull(courseId);
        TemporaryClassMate tempClass = temporaryClassMateMapper.find(courseId, SiteLocalThread.getSiteIdList());
        return tempClass;
    }

    @Override
    public List<Long> listClassMateId(Long tempClassMateId) {
        Assert.notNull(tempClassMateId);
        return temporaryStudentClassMateMapper.listClassMateId(tempClassMateId, SiteLocalThread.getSiteIdList());

    }
}
