package com.jimmy.dao.entity;

import lombok.Data;

@Data
public class CoursewareStudentAnswer extends BaseEntity {


    private Long courseId;

    private Long coursewareId;

    private Long coursewareItemId;

    private Long studentId;

    private Integer fraction;

    private String result;

    private String tearchResult;


}