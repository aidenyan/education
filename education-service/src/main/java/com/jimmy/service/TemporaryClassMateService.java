package com.jimmy.service;

import com.jimmy.dao.entity.StudentInfo;
import com.jimmy.dao.entity.TemporaryClassMate;
import com.jimmy.dao.entity.TemporaryStudentClassMate;

import java.util.List;

/**
 * @ClassName: TemporaryClassMateService
 * @Description:
 * @author: aiden
 * @date: 2019/6/12/012.
 */
public interface TemporaryClassMateService {

    /**
     * 根据临时表查找学生信息
     *
     * @param tempClassMateId
     * @return
     */
    List<TemporaryStudentClassMate> list(Long tempClassMateId);

    /**
     * 根据临时表查找学生信息
     */
    List<TemporaryStudentClassMate> listBySize(Long tempClassMateId, Long startNum, Long limitNum);

    /**
     * 根据临时表查找学生信息总数
     */
    Long count(Long tempClassMateId);

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

    /**
     * 更新临时班级中的机器信息
     */
    void updateMachineId(Long machineId, Long studentId, Long tempClassMateId);

    /**
     * 更新临时班级中的签到
     */
    void updateRegister(Long studentId, Long tempClassMateId);


    /**
     * 更新临时班级中的签到
     */
    void updateAskLevelByStudent(Boolean isAskLevel, Long studentId, Long tempClassMateId);

    /**
     * 更新临时班级中的签到
     */
    void updateAskLevelByMachine(Boolean isAskLevel, Long machine, Long tempClassMateId);
}
