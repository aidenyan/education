package com.jimmy.service.impl;

import com.jimmy.core.local.thread.LoginLocalThread;
import com.jimmy.dao.entity.CourseStudentProcess;
import com.jimmy.dao.local.thread.SiteLocalThread;
import com.jimmy.dao.mapper.CourseStudentProcessMapper;
import com.jimmy.service.CourseStudentProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CourseStudentProcessServiceImpl implements CourseStudentProcessService {
    @Autowired
    private CourseStudentProcessMapper courseStudentProcessMapper;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int update(CourseStudentProcess courseStudentProcess) {
        Assert.notNull(courseStudentProcess);
        CourseStudentProcess tempCourseStudentProcess = courseStudentProcessMapper.findProcess(courseStudentProcess.getMachineId(), courseStudentProcess.getCourseId(), courseStudentProcess.getCoursewareId(), courseStudentProcess.getStudentId(), SiteLocalThread.getSiteIdList());
        if (tempCourseStudentProcess == null) {
            courseStudentProcess.setModifyId(LoginLocalThread.get());
            courseStudentProcess.setCreateId(LoginLocalThread.get());
            courseStudentProcess.setSiteId(SiteLocalThread.getSiteId());
            return courseStudentProcessMapper.insert(courseStudentProcess);
        } else {
            CourseStudentProcess updateCourseStudentProcess = new CourseStudentProcess();
            updateCourseStudentProcess.setModifyId(LoginLocalThread.get());
            updateCourseStudentProcess.setCreateId(LoginLocalThread.get());
            updateCourseStudentProcess.setSiteId(SiteLocalThread.getSiteId());
            updateCourseStudentProcess.setId(tempCourseStudentProcess.getId());
            updateCourseStudentProcess.setStepNum(courseStudentProcess.getStepNum());
            updateCourseStudentProcess.setCoursewareItemId(courseStudentProcess.getCoursewareItemId());
            updateCourseStudentProcess.setCoursewareItemName(courseStudentProcess.getCoursewareItemName());
            return courseStudentProcessMapper.updateProperty(updateCourseStudentProcess);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int endProcess(Long machineId, Long courseId) {
        Assert.notNull(machineId);
        Assert.notNull(courseId);
        return courseStudentProcessMapper.endProcess(machineId, courseId, SiteLocalThread.getSiteId());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateBatch(Long machineId, Long courseId, List<Long> studentIdList, Integer stepNum, Long coursewareId, Long coursewareItemId, String coursewareItemName) {
        Assert.notNull(machineId);
        Assert.notNull(courseId);
        Assert.notNull(stepNum);
        Assert.notNull(coursewareItemId);
        Assert.notEmpty(studentIdList);
        Assert.isTrue(!StringUtils.isEmpty(coursewareItemName));
        CourseStudentProcess courseStudentProcess;
        for (Long studentId : studentIdList) {
            courseStudentProcess = new CourseStudentProcess();
            courseStudentProcess.setCoursewareItemName(coursewareItemName);
            courseStudentProcess.setCoursewareItemId(coursewareItemId);
            courseStudentProcess.setStepNum(stepNum);
            courseStudentProcess.setCourseId(courseId);
            courseStudentProcess.setCoursewareId(coursewareId);
            courseStudentProcess.setMachineId(machineId);
            courseStudentProcess.setStudentId(studentId);
            update(courseStudentProcess);
        }

    }

    @Override
    public List<CourseStudentProcess> list(Long courseId) {
        Assert.notNull(courseId);
        return courseStudentProcessMapper.list(courseId, SiteLocalThread.getSiteIdList());
    }
}
