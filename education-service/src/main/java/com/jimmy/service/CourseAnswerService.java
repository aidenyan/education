package com.jimmy.service;

import com.jimmy.dao.entity.CourseAnswer;

import java.util.List;

public interface CourseAnswerService {
    /**
     * 获取学生的回答信息
     */
    List<CourseAnswer> listMachineAnswer(Long courseId, Long machineId,
                                         List<Long> itemIdList);

    /**
     * 更新需要更新信息
     */
    void update(List<CourseAnswer> courseAnswerList);

    List<CourseAnswer> listMachineAnswer(Long courseId, List<Long> machineIdList, List<Long> itemIdList);
}
