package com.jimmy.dao.entity;

import lombok.Data;

@Data
public class CoursewareItem extends BaseEntity {


    private Byte type;

    private Byte contentType;

    private Long resourceId;

    private String content;


}