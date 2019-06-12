package com.jimmy.dao.entity;

import lombok.Data;

@Data
public class CourseStudent extends BaseEntity {

    /**
     * 课程ID
     */
    private Long courseId;
    /**
     * 机器ID
     */
    private Long machineId;
    /**
     * 学生ID
     */
    private Long studentId;
    /**
     * 状态0：课程机器分布完成，1:课程完成
     */
    private Integer status;

}