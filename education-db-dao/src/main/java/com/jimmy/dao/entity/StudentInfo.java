package com.jimmy.dao.entity;

import lombok.Data;

import java.util.Date;

@Data
public class StudentInfo extends BaseEntity {

    /**
     * IC卡
     */
    private String idCard;
    /**
     * 班级ID
     */
    private Long classmateId;
    /**
     * 名字
     */
    private String name;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * email
     */
    private String email;
    /**
     * 是否生效
     */
    private Boolean isEnabled;
    /**
     * 密码
     */
    private String password;
    /**
     * 真实的姓名
     */
    private String realName;
    /**
     * 头部照片ID
     */
    private String headerUrl;
    /**
     * 生日
     */
    private Date birthTime;
    /**
     * 手机号码
     */
    private String mobile;
    /**
     * 电话号码
     */
    private String telephone;
    /**
     * token
     */
    private String appToken;
    /**
     * 是否已经删除
     */
    private Boolean isDeleted;
    /**
     * 头部特征
     */
    private String headerInfo;

    /**
     * 机床ID
     */
    private Long machineId;
    /**
     * 特征版本
     */
    private Integer faceVersion;
}