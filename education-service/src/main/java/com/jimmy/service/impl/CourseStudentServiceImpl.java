package com.jimmy.service.impl;

import com.jimmy.core.local.thread.LoginLocalThread;
import com.jimmy.dao.entity.CourseStudent;
import com.jimmy.dao.local.thread.SiteLocalThread;
import com.jimmy.dao.mapper.CourseStudentMapper;
import com.jimmy.service.CourseStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @ClassName: CourseStudentServiceImpl
 * @Description:
 * @author: aiden
 * @date: 2019/6/12/012.
 */
@Service
@Transactional(readOnly = true)
public class CourseStudentServiceImpl implements CourseStudentService {

    @Autowired
    private CourseStudentMapper courseStudentMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(List<CourseStudent> courseStudentList) {
        Assert.notEmpty(courseStudentList);
        courseStudentList.forEach(courseStudent -> save(courseStudent));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(CourseStudent courseStudent) {
        Assert.notNull(courseStudent);
        Assert.notNull(courseStudent.getCourseId());
        Assert.notNull(courseStudent.getMachineId());
        Assert.notNull(courseStudent.getStudentId());
        courseStudentMapper.deleted(courseStudent.getCourseId(), courseStudent.getStudentId(), SiteLocalThread.getSiteId());
        courseStudent.setModifyId(LoginLocalThread.get());
        courseStudent.setCreateId(LoginLocalThread.get());
        courseStudent.setSiteId(SiteLocalThread.getSiteId());
        courseStudentMapper.insert(courseStudent);
    }

    @Override
    public List<CourseStudent> list(Long courseId, Integer status) {
        Assert.notNull(courseId);
        return courseStudentMapper.listByCourseId(courseId, status, null, SiteLocalThread.getSiteIdList());
    }

    @Override
    public List<CourseStudent> list(Long courseId, Long machine) {
        Assert.notNull(courseId);
        Assert.notNull(machine);
        return courseStudentMapper.listByCourseId(courseId, null, machine, SiteLocalThread.getSiteIdList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateCourseStudentStatus(Long courseId, Long studentId, Integer status) {
        Assert.notNull(courseId);
        Assert.notNull(studentId);
        Assert.notNull(status);
        courseStudentMapper.updateCourseStudentStatus(courseId, studentId, status, SiteLocalThread.getSiteId());
    }
}
