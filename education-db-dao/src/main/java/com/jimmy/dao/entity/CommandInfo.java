package com.jimmy.dao.entity;

import lombok.Data;

@Data
public class CommandInfo extends BaseEntity {

    private Long courseId;

    private Integer direction;

    private String operationName;

    private Long operationId;

    private Integer commandType;

    private String sn;

    private String content;

}