package com.jimmy.dao.entity;

import lombok.Data;

import java.util.Date;

@Data
public class CourseStudentProcess extends BaseEntity {


    private Long courseId;

    private Long machineId;

    private Long coursewareId;

    private Long coursewareItemId;

    private String coursewareItemName;

    private Date updateTime;

    private Long studentId;

    private Integer stepNum;

    private Boolean isEnd;

}