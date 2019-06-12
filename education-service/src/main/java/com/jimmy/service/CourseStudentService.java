package com.jimmy.service;

import com.jimmy.dao.entity.CourseStudent;

import java.util.List;

/**
 * @ClassName: CourseStudentService
 * @Description:
 * @author: aiden
 * @date: 2019/6/12/012.
 */
public interface CourseStudentService {
    /**
     * 保存信息
     *
     * @param courseStudentList 课程学ID
     */
    void save(List<CourseStudent> courseStudentList);

    /**
     * 保存信息
     *
     * @param courseStudent 课程学ID
     */
    void save(CourseStudent courseStudent);

    /**
     * 获取该课程已经结束的学生
     */
    List<CourseStudent> list(Long courseId,Integer status);

    /**
     * 学生结束课程
     */
    void updateCourseStudentStatus(Long courseId, Long studentId,Integer status);
}
