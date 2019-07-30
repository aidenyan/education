package com.jimmy.service;

import com.jimmy.dao.entity.CourseStudentRegister;

import java.util.List;
import java.util.Map;

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
    void save(CourseStudentRegister register,Long tempClassId,Long studentId);

    /**
     * ±£´æ
     *
     * @param registerList
     */
    void save(List<CourseStudentRegister> registerList,Long tempClassId,Map<Long,Long> courseStudentMap);
}
