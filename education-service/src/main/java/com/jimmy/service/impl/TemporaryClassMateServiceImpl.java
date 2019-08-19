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
    public List<TemporaryStudentClassMate> list(Long tempClassMateId) {
        Assert.notNull(tempClassMateId);
        return temporaryStudentClassMateMapper.list(tempClassMateId, SiteLocalThread.getSiteIdList());

    }

    @Override
    public List<TemporaryStudentClassMate> listByMachine(Long tempClassMateId, Long machineId) {
        Assert.notNull(tempClassMateId);
        Assert.notNull(machineId);
        return temporaryStudentClassMateMapper.listByMachine(tempClassMateId, machineId, SiteLocalThread.getSiteIdList());
    }

    @Override
    public List<TemporaryStudentClassMate> listBySize(Long tempClassMateId, Long startNum, Long limitNum) {
        Assert.notNull(tempClassMateId);
        Assert.notNull(startNum);
        Assert.notNull(limitNum);
        return temporaryStudentClassMateMapper.listBySize(tempClassMateId, startNum, limitNum, SiteLocalThread.getSiteIdList());
    }

    @Override
    public Long count(Long tempClassMateId) {
        Assert.notNull(tempClassMateId);
        return temporaryStudentClassMateMapper.count(tempClassMateId, SiteLocalThread.getSiteIdList());
    }

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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateMachineId(Long machineId, Long studentId, Long tempClassMateId) {
        Assert.notNull(machineId);
        Assert.notNull(studentId);
        Assert.notNull(tempClassMateId);
        TemporaryStudentClassMate temporaryStudentClassMate = new TemporaryStudentClassMate();
        temporaryStudentClassMate.setTemporaryClassId(tempClassMateId);
        temporaryStudentClassMate.setMachineId(machineId);
        temporaryStudentClassMate.setStudentId(studentId);
        temporaryStudentClassMate.setSiteId(SiteLocalThread.getSiteId());
        temporaryStudentClassMate.setCreateId(LoginLocalThread.get());
        temporaryStudentClassMateMapper.updateByCourseStatus(temporaryStudentClassMate);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateRegister(Long studentId, Long registerCommandId, Long tempClassMateId) {
        Assert.notNull(studentId);
        Assert.notNull(tempClassMateId);
        TemporaryStudentClassMate temporaryStudentClassMate = new TemporaryStudentClassMate();
        temporaryStudentClassMate.setTemporaryClassId(tempClassMateId);
        temporaryStudentClassMate.setIsRegister(Boolean.TRUE);
        temporaryStudentClassMate.setStudentId(studentId);
        temporaryStudentClassMate.setRegisterCommandId(registerCommandId);
        temporaryStudentClassMate.setSiteId(SiteLocalThread.getSiteId());
        temporaryStudentClassMate.setCreateId(LoginLocalThread.get());
        temporaryStudentClassMateMapper.updateByCourseStatus(temporaryStudentClassMate);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateAskLevelByStudent(Boolean isAskLevel, Long studentId, Long tempClassMateId) {
        Assert.notNull(studentId);
        Assert.notNull(tempClassMateId);
        Assert.notNull(isAskLevel);
        TemporaryStudentClassMate temporaryStudentClassMate = new TemporaryStudentClassMate();
        temporaryStudentClassMate.setTemporaryClassId(tempClassMateId);
        temporaryStudentClassMate.setIsAskLevel(isAskLevel);
        temporaryStudentClassMate.setStudentId(studentId);
        temporaryStudentClassMate.setSiteId(SiteLocalThread.getSiteId());
        temporaryStudentClassMate.setCreateId(LoginLocalThread.get());

        temporaryStudentClassMateMapper.updateByCourseStatus(temporaryStudentClassMate);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateAskLevelByMachine(Boolean isAskLevel, Long machineId, Long tempClassMateId) {
        Assert.notNull(machineId);
        Assert.notNull(tempClassMateId);
        Assert.notNull(isAskLevel);
        TemporaryStudentClassMate temporaryStudentClassMate = new TemporaryStudentClassMate();
        temporaryStudentClassMate.setTemporaryClassId(tempClassMateId);
        temporaryStudentClassMate.setIsAskLevel(isAskLevel);
        temporaryStudentClassMate.setMachineId(machineId);
        temporaryStudentClassMate.setSiteId(SiteLocalThread.getSiteId());
        temporaryStudentClassMate.setCreateId(LoginLocalThread.get());

        temporaryStudentClassMateMapper.updateByCourseStatus(temporaryStudentClassMate);

    }
}
