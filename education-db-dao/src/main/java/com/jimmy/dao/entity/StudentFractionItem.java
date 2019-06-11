package com.jimmy.dao.entity;

import lombok.Data;

@Data
public class StudentFractionItem extends BaseEntity {


    private Long fractionId;

    private Byte type;

    private Long dictionaryItemId;

    private String name;

    private Integer fraction;


}