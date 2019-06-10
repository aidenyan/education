package com.jimmy.dao.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TeacherStaffInfo extends BaseEntity {


    private String name;

    private Integer sex;

    private Integer staffType;

    private String staffName;

    private String email;

    private Boolean isEnabled;

    private Boolean isLocked;

    private Date lockedDate;

    private Date loginDate;

    private Integer loginFailureCount;

    private String loginIp;

    private String password;

    private String realName;

    private String headerUrl;

    private Date birthTime;

    private String mobile;

    private String telephone;

    private String webToken;

    private String appToken;

    private String padAppToken;

    private Boolean isDeleted;

    private String headerInfo;
}