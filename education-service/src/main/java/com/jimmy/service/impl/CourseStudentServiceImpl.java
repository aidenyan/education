package com.jimmy.service.impl;

import com.jimmy.core.local.thread.LoginLocalThread;
import com.jimmy.dao.entity.CourseStudent;
import com.jimmy.dao.entity.TemporaryClassMate;
import com.jimmy.dao.local.thread.SiteLocalThread;
import com.jimmy.dao.mapper.CourseStudentMapper;
import com.jimmy.service.CourseStudentService;
import com.jimmy.service.TemporaryClassMateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
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

    @Autowired
    private TemporaryClassMateService temporaryClassMateService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(List<CourseStudent> courseStudentList) {
        Assert.notEmpty(courseStudentList);
        CourseStudent courseStudent = courseStudentList.stream().findFirst().get();
        TemporaryClassMate temporaryClassMate = temporaryClassMateService.findTempClassMate(courseStudent.getCourseId());
        courseStudentMapper.deletedByMachineId(courseStudent.getCourseId(), courseStudent.getMachineId(), SiteLocalThread.getSiteId());
        courseStudentList.forEach(courseStudentInfo -> save(courseStudentInfo, temporaryClassMate.getId()));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(CourseStudent courseStudent) {
        Assert.notNull(courseStudent);
        Assert.notNull(courseStudent.getCourseId());
        Assert.notNull(courseStudent.getStudentId());
        List<CourseStudent> updateCourseStudentList = courseStudentMapper.find(courseStudent.getCourseId(), Arrays.asList(courseStudent.getStudentId()), null, SiteLocalThread.getSiteIdList());
        CourseStudent updateCourseStudent = null;
        if (!CollectionUtils.isEmpty(updateCourseStudentList)) {
            updateCourseStudent = updateCourseStudentList.stream().findFirst().get();
        }
        courseStudent.setModifyId(LoginLocalThread.get());
        courseStudent.setCreateId(LoginLocalThread.get());
        courseStudent.setSiteId(SiteLocalThread.getSiteId());
        if (updateCourseStudent != null) {
            updateCourseStudent.setCoursewareId(courseStudent.getCoursewareId());
            updateCourseStudent.setMachineId(updateCourseStudent.getMachineId());
            courseStudentMapper.updateProperty(updateCourseStudent);
        } else {
            courseStudentMapper.insert(courseStudent);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(CourseStudent courseStudent, Long temporaryClassMateId) {
        Assert.notNull(courseStudent);
        Assert.notNull(courseStudent.getCourseId());
        Assert.notNull(courseStudent.getMachineId());
        Assert.notNull(courseStudent.getStudentId());

        temporaryClassMateService.updateMachineId(courseStudent.getMachineId(), courseStudent.getStudentId(), temporaryClassMateId);
        save(courseStudent);

    }

    @Override
    public List<CourseStudent> list(Long courseId) {
        Assert.notNull(courseId);
        return courseStudentMapper.listByCourseId(courseId, null, null, SiteLocalThread.getSiteIdList());

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
    public List<CourseStudent> find(Long courseId, Long studentId, Long machinaId) {
        Assert.notNull(courseId);
        Assert.notNull(studentId);
        return find(courseId, Arrays.asList(studentId), machinaId);
    }

    @Override
    public List<CourseStudent> find(Long courseId, List<Long> studentIdList, Long machinaId) {
        Assert.notNull(courseId);
        Assert.notEmpty(studentIdList);
        return courseStudentMapper.find(courseId, studentIdList, machinaId, SiteLocalThread.getSiteIdList());
    }

    @Override
    public CourseStudent find(Long courseStudentId) {
        return courseStudentMapper.findById(courseStudentId, SiteLocalThread.getSiteIdList());
    }

    @Override
    public void updateCoursewareId(Long id, Long coursewareId) {
        Assert.notNull(id);
        Assert.notNull(coursewareId);
        CourseStudent courseStudent = new CourseStudent();
        courseStudent.setModifyId(LoginLocalThread.get());
        courseStudent.setCreateId(LoginLocalThread.get());
        courseStudent.setSiteId(SiteLocalThread.getSiteId());
        courseStudent.setId(id);
        courseStudent.setCoursewareId(coursewareId);
        courseStudentMapper.updateProperty(courseStudent);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateCourseStudentStatus(Long courseId, Long machinaId, Integer status) {
        Assert.notNull(courseId);
        Assert.notNull(machinaId);
        Assert.notNull(status);
        courseStudentMapper.updateCourseStudentStatus(courseId, machinaId, status, SiteLocalThread.getSiteId());
    }

}
