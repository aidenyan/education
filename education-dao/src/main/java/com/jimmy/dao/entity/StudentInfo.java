package com.jimmy.dao.entity;

import lombok.Data;

import java.util.Date;

@Data
public class StudentInfo extends BaseEntity {


    private Long classmateId;

    private String name;

    private Byte sex;

    private String email;

    private Boolean isEnabled;

    private String password;

    private String realName;

    private String headerUrl;

    private Date birthTime;

    private String mobile;

    private String telephone;

    private String appToken;

    private Byte isDeleted;


    private String headerInfo;

}