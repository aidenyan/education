package com.jimmy.dao.entity;

import lombok.Data;

@Data
public class CoursewareItem extends BaseEntity {


    private Integer type;

    private Integer contentType;

    private Long resourceId;

    private String content;

    private Integer orderNum;

    private Long coursewareId;


}