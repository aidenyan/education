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
     * ������Ϣ
     *
     * @param courseStudentList �γ�ѧID
     */
    void save(List<CourseStudent> courseStudentList);

    /**
     * ������Ϣ
     *
     * @param courseStudent �γ�ѧID
     */
    void save(CourseStudent courseStudent);

    /**
     * ��ȡ�ÿγ��Ѿ�������ѧ��
     */
    List<CourseStudent> list(Long courseId,Integer status);

    /**
     * ѧ�������γ�
     */
    void updateCourseStudentStatus(Long courseId, Long studentId,Integer status);
}
