package com.jimmy.service.impl;

import com.jimmy.core.local.thread.LoginLocalThread;
import com.jimmy.dao.entity.CourseLinkKey;
import com.jimmy.dao.entity.Courseware;
import com.jimmy.dao.entity.CoursewareItem;
import com.jimmy.dao.local.thread.SiteLocalThread;
import com.jimmy.dao.mapper.CourseLinkMapper;
import com.jimmy.dao.mapper.CoursewareItemMapper;
import com.jimmy.dao.mapper.CoursewareMapper;
import com.jimmy.model.vo.CoursewareDetailVO;
import com.jimmy.service.CoursewareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @ClassName: CoursewareServiceImpl
 * @Description:
 * @author: aiden
 * @date: 2019/6/12/012.
 */

@Service
@Transactional(readOnly = true)
public class CoursewareServiceImpl implements CoursewareService {

    @Autowired
    private CoursewareMapper coursewareMapper;
    @Autowired
    private CourseLinkMapper courseLinkMapper;

    @Autowired
    private CoursewareItemMapper coursewareItemMapper;

    @Override
    public List<CoursewareDetailVO> list(Long courseId) {
        Assert.notNull(courseId);
        List<Courseware> coursewareList = coursewareMapper.list(courseId, SiteLocalThread.getSiteIdList());
        if (CollectionUtils.isEmpty(coursewareList)) {
            return Collections.EMPTY_LIST;
        }
        Map<Long, Courseware> coursewareIdMap = new HashMap<>();
        coursewareList.forEach(courseware -> coursewareIdMap.put(courseware.getId(), courseware));
        List<CoursewareItem> coursewareItemList = coursewareItemMapper.listByCoursewareIdList(coursewareIdMap.keySet(), null, SiteLocalThread.getSiteIdList());
        Map<Long, List<CoursewareItem>> itemMap = new HashMap<>();
        coursewareItemList.forEach(coursewareItem -> {
            List<CoursewareItem> itemList = itemMap.get(coursewareItem.getCoursewareId());
            if (itemList == null) {
                itemList = new ArrayList<>();
                itemMap.put(coursewareItem.getCoursewareId(), itemList);
            }
            itemList.add(coursewareItem);
        });
        List<CoursewareDetailVO> resultList = new ArrayList<>();
        coursewareList.forEach(courseware -> {
            CoursewareDetailVO coursewareDetailVO = new CoursewareDetailVO();
            coursewareDetailVO.setCourseware(courseware);
            coursewareDetailVO.setCoursewareItemList(itemMap.get(courseware.getId()));
            resultList.add(coursewareDetailVO);
        });

        return resultList;
    }

    @Override
    public List<CoursewareItem> listByCoursewareId(Long coursewareId, Integer contentType) {
        Assert.notNull(coursewareId);
        Assert.notNull(contentType);
        return coursewareItemMapper.listByCoursewareId(coursewareId, contentType, SiteLocalThread.getSiteIdList());
    }

    @Override
    public List<CoursewareItem> listByCourseId(Long courseId, Integer contentType) {
        Assert.notNull(courseId);
        Assert.notNull(contentType);
        List<Courseware> coursewareList = coursewareMapper.list(courseId, SiteLocalThread.getSiteIdList());
        if (CollectionUtils.isEmpty(coursewareList)) {
            return Collections.EMPTY_LIST;
        }
        List<Long> coursewaredIdList = new ArrayList<>();
        coursewareList.forEach(courseware -> coursewaredIdList.add(courseware.getId()));
        return coursewareItemMapper.listByCoursewareIdList(coursewaredIdList, contentType, SiteLocalThread.getSiteIdList());

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Courseware courseware, List<CoursewareItem> itemList, Long courseId) {
        courseware.setCreateId(LoginLocalThread.get());
        courseware.setModifyId(LoginLocalThread.get());
        courseware.setSiteId(SiteLocalThread.getSiteId());
        if (courseware.getId() != null) {
            Courseware tempCourseware = coursewareMapper.find(courseware.getId(), SiteLocalThread.getSiteIdList());
            Assert.notNull(tempCourseware);
            Assert.isTrue(!tempCourseware.getIsUsed());
            coursewareMapper.updateProperty(courseware);
        } else {
            courseware.setIsUsed(false);
            coursewareMapper.insert(courseware);
            if (courseId != null) {
                CourseLinkKey courseLinkKey = new CourseLinkKey();
                courseLinkKey.setCourseId(courseId);
                courseLinkKey.setCoursewareId(courseware.getId());
                courseLinkMapper.insert(courseLinkKey);
            }
        }
        coursewareItemMapper.deleted(courseware.getId(), SiteLocalThread.getSiteIdList());
        for (CoursewareItem coursewareItem : itemList) {
            coursewareItem.setCreateId(LoginLocalThread.get());
            coursewareItem.setModifyId(LoginLocalThread.get());
            coursewareItem.setSiteId(SiteLocalThread.getSiteId());
            coursewareItem.setCoursewareId(courseware.getId());
            coursewareItemMapper.insert(coursewareItem);
        }
    }
}
