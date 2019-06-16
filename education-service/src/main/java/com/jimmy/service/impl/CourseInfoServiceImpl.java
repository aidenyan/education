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
    @Transactional(rollbackFor = Exception.class)
    public void save(CourseInfo courseInfo) {
        Assert.notNull(courseInfo);
        courseInfo.setModifyId(LoginLocalThread.get());
        courseInfo.setCreateId(LoginLocalThread.get());
        courseInfo.setSiteId(SiteLocalThread.getSiteId());
        courseInfo.setUsedStatus(0);
        if (courseInfo.getId() == null) {
            courseInfoMapper.insert(courseInfo);
        } else {
            CourseInfo tempCourseInfo = courseInfoMapper.findById(courseInfo.getId(), SiteLocalThread.getSiteIdList());
            Assert.notNull(tempCourseInfo);
            Assert.isTrue(tempCourseInfo.getUsedStatus() == 0);
            courseInfoMapper.update(courseInfo);
        }
    }

    @Override
    public CourseInfo findByRoomId(Long roomId) {
        Assert.notNull(roomId);
        return courseInfoMapper.findByRoomId(roomId, SiteLocalThread.getSiteIdList());
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
    @Transactional(rollbackFor = Exception.class)
    public void useCourse(Long courseId, Integer usedStatus,Long roomId) {
        Assert.notNull(courseId);
        CourseInfo courseInfo = new CourseInfo();
        courseInfo.setUsedStatus(usedStatus);
        courseInfo.setId(courseId);
        courseInfo.setModifyId(LoginLocalThread.get());
        courseInfo.setSiteId(SiteLocalThread.getSiteId());
        if (usedStatus == 1) {
            Assert.notNull(roomId);
            courseInfoMapper.updateUsedStatus(courseId,roomId,SiteLocalThread.getSiteId());
        }
        courseInfoMapper.updateProperty(courseInfo);
    }

    @Override
    public List<CourseInfo> listCouldUsed(Long roomId, Long teacherId, Integer size) {
        return courseInfoMapper.listCouldUsed(roomId, teacherId, size, SiteLocalThread.getSiteIdList());
    }
}
