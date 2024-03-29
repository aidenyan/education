package com.jimmy.dao.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CourseAnswer extends BaseEntity {

    /**
     * 课程ID
     */
    private Long courseId;
    /**
     * 机床ID
     */
    private Long machineId;
    /**
     * 课件ID
     */
    private Long coursewareId;
    /**
     * 课件详细ID
     */
    private Long coursewareItemId;
    /**
     * 分数
     */
    private BigDecimal fraction;
    /**
     * 学生的回答
     */
    private String studentResult;
    /**
     * 老师的回答
     */
    private String tearchResult;

}