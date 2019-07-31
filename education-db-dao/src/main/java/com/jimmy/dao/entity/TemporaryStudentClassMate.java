package com.jimmy.dao.entity;

import lombok.Data;

@Data
public class TemporaryStudentClassMate extends BaseEntity {


    private Long temporaryClassId;

    private Long classmateId;

    private Long studentId;

    private Boolean isAskLevel;

    private Boolean isRegister;

    private Long machineId;
    private Long registerCommandId;
}