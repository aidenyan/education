package com.jimmy.dao.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class StudentFraction extends BaseEntity {


    private Long courseId;

    private BigDecimal fraction;

    private Long studentId;


}