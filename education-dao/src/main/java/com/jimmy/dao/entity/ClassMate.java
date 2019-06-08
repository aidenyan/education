package com.jimmy.dao.entity;

import lombok.Data;

@Data
public class ClassMate extends BaseEntity {

    private String name;

    private Boolean isDeleted;

    private String description;
}