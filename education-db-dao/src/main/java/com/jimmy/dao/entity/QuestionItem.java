package com.jimmy.dao.entity;

import lombok.Data;

@Data
public class QuestionItem extends BaseEntity {
    private Long questionId;

    private String content;

    private Boolean isResult;


}