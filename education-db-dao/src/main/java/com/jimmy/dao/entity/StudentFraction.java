package com.jimmy.dao.entity;

import lombok.Data;

@Data
public class StudentFraction extends BaseEntity {


    private Long courseId;

    private Integer fraction;


}