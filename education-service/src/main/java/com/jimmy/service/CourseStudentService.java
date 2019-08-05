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
    void save(CourseStudent courseStudent,Long temporaryClassMateId);

    /**
     * 获取该课程所有分配的学生
     */
    List<CourseStudent> list(Long courseId);
    /**
     * 获取该课程已经结束的学生
     */
    List<CourseStudent> list(Long courseId, Integer status);

    /**
     * 获取某个机器上的所有学生
     */
    List<CourseStudent> list(Long courseId, Long machine);
    /**
     * 查找机床等路的信息
     */
    List<CourseStudent> find(Long courseId, Long studentId, Long machinaId);
    /**
     * 查找机床等路的信息
     */
    List<CourseStudent> find(Long courseId, List<Long> studentIdList, Long machinaId);
    /**
     * 查找机床等路的信息
     */
    CourseStudent find(Long courseStudentId);

    /**
     * 更新课程ID
     * @param id
     * @param coursewareId
     */
    void updateCoursewareId(Long id,Long coursewareId);
    /**
     * 学生结束课程
     */
    void updateCourseStudentStatus(Long courseId, Long studentId, Integer status);
}
