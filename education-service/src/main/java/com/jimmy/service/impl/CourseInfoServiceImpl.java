package com.jimmy.service.impl;

import com.jimmy.core.local.thread.LoginLocalThread;
import com.jimmy.dao.entity.CourseInfo;
import com.jimmy.dao.local.thread.SiteLocalThread;
import com.jimmy.dao.mapper.CourseInfoMapper;
import com.jimmy.service.CourseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @ClassName: CourseInfoServiceImpl
 * @Description:
 * @author: aiden
 * @date: 2019/6/10/010.
 */
@Service
@Transactional(readOnly = true)
public class CourseInfoServiceImpl implements CourseInfoService {

    @Autowired
    private CourseInfoMapper courseInfoMapper;

    @Override
    public void save(CourseInfo courseInfo) {
        Assert.notNull(courseInfo);
        courseInfo.setModifyId(LoginLocalThread.get());
        courseInfo.setCreateId(LoginLocalThread.get());
        courseInfo.setSiteId(SiteLocalThread.getSiteId());
        courseInfo.setIsUsed(Boolean.FALSE);
        if (courseInfo.getId() == null) {
            courseInfoMapper.insert(courseInfo);
        } else {
            CourseInfo tempCourseInfo = courseInfoMapper.findById(courseInfo.getId(), SiteLocalThread.getSiteIdList());
            Assert.notNull(tempCourseInfo);
            Assert.isTrue(!tempCourseInfo.getIsUsed());
            courseInfoMapper.update(courseInfo);
        }
    }

    @Override
    public CourseInfo findById(Long id) {
        Assert.notNull(id);
        return courseInfoMapper.findById(id, SiteLocalThread.getSiteIdList());
    }

    @Override
    public List<CourseInfo> list(String name) {
        return courseInfoMapper.list(name, SiteLocalThread.getSiteIdList());
    }

    @Override
    public List<CourseInfo> listCouldUsed(Long roomId, Long teacherId, Integer size) {
        return courseInfoMapper.listCouldUsed(roomId, teacherId, size, SiteLocalThread.getSiteIdList());
    }
}