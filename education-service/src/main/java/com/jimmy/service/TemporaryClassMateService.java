package com.jimmy.service;

import com.jimmy.dao.entity.StudentInfo;
import com.jimmy.dao.entity.TemporaryClassMate;

import java.util.List;

/**
 * @ClassName: TemporaryClassMateService
 * @Description:
 * @author: aiden
 * @date: 2019/6/12/012.
 */
public interface TemporaryClassMateService {
    /**
     * 保存临时表
     */
    void save(TemporaryClassMate temporaryClassMate, List<StudentInfo> studentList);

    /**
     * 根据课程ID获取学生信息
     *
     * @param courseId 课程ID
     * @return List<学生信息>
     */
    List<StudentInfo> findStudentId(Long courseId);

    /**
     * 根据课程ID获取临时的班级
     *
     * @param courseId 课程ID
     * @return List<学生信息>
     */
    TemporaryClassMate findTempClassMate(Long courseId);

    /**
     * 查找临时班级的组成的班级
     *
     * @param tempClassMateId
     * @return
     */
    List<Long> listClassMateId(Long tempClassMateId);

}
