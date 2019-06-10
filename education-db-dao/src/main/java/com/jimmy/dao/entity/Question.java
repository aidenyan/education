package com.jimmy.dao.entity;

import lombok.Data;

@Data
public class Question extends BaseEntity {


    private String question;

    private Integer type;

    private String result;

    private Boolean isDeleted;

}