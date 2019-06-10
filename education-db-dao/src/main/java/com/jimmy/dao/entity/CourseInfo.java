package com.jimmy.dao.entity;

import lombok.Data;

import java.util.Date;

@Data
public class CourseInfo extends BaseEntity {


    private String name;

    private Date startTime;

    private Integer timeLong;

    private Long roomId;

    private Long teacherId;

    private Boolean isUsed;

    private String description;

}