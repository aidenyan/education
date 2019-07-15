package com.jimmy.dao.entity;

import lombok.Data;

@Data
public class TemporaryClassMate extends BaseEntity {

    private String name;

    private Long courseId;

    private String description;

    private Boolean isDeleted;

}