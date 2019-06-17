package com.jimmy.service;

import com.jimmy.dao.entity.CourseStudentRegister;

import java.util.List;

/**
 * @ClassName: CourseStudentRegisterService
 * @Description:
 * @author: aiden
 * @date: 2019/6/17/017.
 */
public interface CourseStudentRegisterService {
    /**
     * ±£´æ
     *
     * @param register
     */
    void save(CourseStudentRegister register);

    /**
     * ±£´æ
     *
     * @param registerList
     */
    void save(List<CourseStudentRegister> registerList);
}
