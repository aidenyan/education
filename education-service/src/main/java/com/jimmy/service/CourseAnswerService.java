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
     * ��ȡѧ���Ļش���Ϣ
     */
    CourseAnswer findByCourseStudent(Long courseId, Long machineId, Long coursewareItemId);

    /**
     * ��ȡѧ���Ļش���Ϣ
     */
    List<CourseAnswer> listByCourseStudentId(Long courseId, Long machineId);

    /**
     * ��ȡ����ѧ���Ļش���Ϣ
     */
    List<CourseAnswer> listByCourseStudentId(Long courseId);

    /**
     * �����ϰ��ش�Ľ��
     *
     * @param courseAnswer
     */
    void saveTearchResult(CourseAnswer courseAnswer);
}
