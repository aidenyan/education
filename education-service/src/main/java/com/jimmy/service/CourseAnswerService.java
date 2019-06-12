package com.jimmy.service;

import com.jimmy.dao.entity.CourseAnswer;

import java.util.List;

/**
 * @ClassName: CourseAnswerService
 * @Description:
 * @author: aiden
 * @date: 2019/6/12/012.
 */
public interface CourseAnswerService {
    /**
     * 获取学生的回答信息
     */
    CourseAnswer findByCourseStudent(Long courseId, Long machineId, Long coursewareItemId);

    /**
     * 获取学生的回答信息
     */
    List<CourseAnswer> listByCourseStudentId(Long courseId, Long machineId);

    /**
     * 获取所有学生的回答信息
     */
    List<CourseAnswer> listByCourseStudentId(Long courseId);

    /**
     * 保存老啊回答的结果
     *
     * @param courseAnswer
     */
    void saveTearchResult(CourseAnswer courseAnswer);
}
