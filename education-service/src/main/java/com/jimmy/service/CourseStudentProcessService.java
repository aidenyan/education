package com.jimmy.service;

import com.jimmy.dao.entity.CourseStudentProcess;

import java.util.List;

public interface CourseStudentProcessService {


    /**
     * 更新进度信息
     *
     * @param courseStudentProcess
     * @return
     */
    int update(CourseStudentProcess courseStudentProcess);

    /**
     * 结束
     *
     * @param machineId
     * @param courseId
     * @return
     */
    int endProcess(Long machineId, Long courseId);

    /**
     * 结束
     *
     * @param machineId
     * @param courseId
     * @return
     */
    void updateBatch(Long machineId, Long courseId, List<Long> studentIdList, Integer stepNum, Long coursewareId, Long coursewareItemId, String coursewareItemName);

    /**
     * 获取进程
     *
     * @param courseId
     * @return
     */
    List<CourseStudentProcess> list(Long courseId);

    /**
     * 获取进程
     *
     * @param courseId
     * @return
     */
    List<CourseStudentProcess> listByMachine(Long courseId,Long machineId);
}
