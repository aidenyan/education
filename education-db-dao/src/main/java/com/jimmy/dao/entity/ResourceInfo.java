package com.jimmy.dao.entity;

import lombok.Data;

@Data
public class ResourceInfo extends BaseEntity {

    private Integer type;

    private Boolean isDeleted;

    private String content;
    private String title;
}