package com.jimmy.service;

import com.jimmy.model.dto.CoursewareDetailVO;

import java.util.List;

/**
 * @ClassName: CoursewareService
 * @Description:
 * @author: aiden
 * @date: 2019/6/12/012.
 */
public interface CoursewareService {
    /**
     * 课程ID查找课件详细信息
     *
     * @param courseId 课程ID
     * @return List<课程信息>
     */
    List<CoursewareDetailVO> list(Long courseId);
}
