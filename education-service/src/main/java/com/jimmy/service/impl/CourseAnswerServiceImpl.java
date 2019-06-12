package com.jimmy.service.impl;

import com.jimmy.core.local.thread.LoginLocalThread;
import com.jimmy.dao.entity.CourseAnswer;
import com.jimmy.dao.local.thread.SiteLocalThread;
import com.jimmy.dao.mapper.CourseAnswerMapper;
import com.jimmy.service.CourseAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @ClassName: CourseAnswerServiceImpl
 * @Description:
 * @author: aiden
 * @date: 2019/6/12/012.
 */
@Service
@Transactional(readOnly = true)
public class CourseAnswerServiceImpl implements CourseAnswerService {

    @Autowired
    private CourseAnswerMapper courseAnswerMapper;

    @Override
    public CourseAnswer findByCourseStudent(Long courseId, Long machineId, Long coursewareItemId) {
        Assert.notNull(courseId);
        Assert.notNull(machineId);
        Assert.notNull(coursewareItemId);
        return courseAnswerMapper.findByCourseStudent(courseId, machineId, coursewareItemId, SiteLocalThread.getSiteIdList());
    }

    @Override
    public List<CourseAnswer> listByCourseStudentId(Long courseId, Long machineId) {
        Assert.notNull(courseId);
        Assert.notNull(machineId);
        return courseAnswerMapper.listByCourseStudentId(courseId, machineId, SiteLocalThread.getSiteIdList());
    }

    @Override
    public List<CourseAnswer> listByCourseStudentId(Long courseId) {
        Assert.notNull(courseId);
        return courseAnswerMapper.listByCourseStudentId(courseId, null, SiteLocalThread.getSiteIdList());
    }

    @Override
    public void saveTearchResult(CourseAnswer courseAnswer) {
        Assert.notNull(courseAnswer);
        CourseAnswer tempCourseAnswer = findByCourseStudent(courseAnswer.getCourseId(), courseAnswer.getMachineId(), courseAnswer.getCoursewareItemId());
        if (tempCourseAnswer == null) {
            courseAnswer.setModifyId(LoginLocalThread.get());
            courseAnswer.setCreateId(LoginLocalThread.get());
            courseAnswer.setSiteId(SiteLocalThread.getSiteId());
            courseAnswerMapper.insert(courseAnswer);
        } else {
            CourseAnswer updateCourseAnswer = new CourseAnswer();
            updateCourseAnswer.setId(tempCourseAnswer.getId());
            updateCourseAnswer.setTearchResult(tempCourseAnswer.getTearchResult());
            updateCourseAnswer.setModifyId(LoginLocalThread.get());
            updateCourseAnswer.setSiteId(SiteLocalThread.getSiteId());
            courseAnswerMapper.updateProperty(updateCourseAnswer);
        }
    }
}
