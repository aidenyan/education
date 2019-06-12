package com.jimmy.dao.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class StudentFractionItem extends BaseEntity {


    private Long fractionId;

    private Integer type;

    private Long dictionaryItemId;

    private String name;

    private BigDecimal fraction;


}