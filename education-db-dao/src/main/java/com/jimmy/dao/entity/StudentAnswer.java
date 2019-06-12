package com.jimmy.dao.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class StudentAnswer extends BaseEntity {

    /**
     * 课程学生关系ID
     */
    private Long courseStudentId;
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