package com.jimmy.dao.entity;

import lombok.Data;

@Data
public class CourseStudentRegister extends BaseEntity {


    private Long courseStudentId;

    private Long commandId;

    private Boolean isRegister;


}