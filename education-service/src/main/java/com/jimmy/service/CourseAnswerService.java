package com.jimmy.service;

import com.jimmy.dao.entity.CourseAnswer;

import java.util.List;

public interface CourseAnswerService {
    /**
     * ��ȡѧ���Ļش���Ϣ
     */
    List<CourseAnswer> listMachineAnswer(Long courseId, Long machineId,
                                         List<Long> itemIdList);

    /**
     * ������Ҫ������Ϣ
     */
    void update(List<CourseAnswer> courseAnswerList);

    List<CourseAnswer> listMachineAnswer(Long courseId, List<Long> machineIdList, List<Long> itemIdList);
}
