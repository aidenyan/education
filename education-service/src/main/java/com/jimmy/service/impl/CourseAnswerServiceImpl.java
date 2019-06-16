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

@Service
@Transactional(readOnly = true)
public class CourseAnswerServiceImpl implements CourseAnswerService {
    @Autowired
    private CourseAnswerMapper courseAnswerMapper;

    @Override
    public List<CourseAnswer> listMachineAnswer(Long courseId, Long machineId, List<Long> itemIdList) {
        Assert.notEmpty(itemIdList);
        Assert.notNull(courseId);
        Assert.notNull(machineId);

        return courseAnswerMapper.listMachineAnswer(courseId, machineId, itemIdList, SiteLocalThread.getSiteIdList());

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(List<CourseAnswer> courseAnswerList) {
        Assert.notEmpty(courseAnswerList);

        courseAnswerList.forEach(courseAnswer -> {
            if (courseAnswer.getId() == null) {
                courseAnswer.setSiteId(SiteLocalThread.getSiteId());
                courseAnswer.setModifyId(LoginLocalThread.get());
                courseAnswer.setCreateId(LoginLocalThread.get());
                courseAnswerMapper.insert(courseAnswer);
            } else {
                courseAnswer.setSiteId(SiteLocalThread.getSiteId());
                courseAnswer.setModifyId(LoginLocalThread.get());
                courseAnswerMapper.updateProperty(courseAnswer);
            }

        });
    }
}
