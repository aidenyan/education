package com.jimmy.mvc.common.model.dto;

import com.jimmy.dao.entity.BaseEntity;
import com.jimmy.mvc.common.model.enums.SexEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("学生基本信息")
public class StudentInfoDTO extends BaseDTO {
    /**
     * IC卡
     */
    @ApiModelProperty("IC卡")
    private String idCard;
    /**
     * 班级ID
     */
    @ApiModelProperty("班级ID")
    private Long classmateId;
    /**
     * 班级名称
     */
    @ApiModelProperty("班级名称")
    private String classmateName;
    /**
     * 名字
     */
    @ApiModelProperty("名字")
    private String name;
    /**
     * 性别
     */
    @ApiModelProperty("性别")
    private SexEnum sex;
    /**
     * email
     */
    @ApiModelProperty("email")
    private String email;
    /**
     * 是否生效
     */
    @ApiModelProperty("是否生效")
    private Boolean isEnabled;
    /**
     * 真实的姓名
     */
    @ApiModelProperty("真实的姓名")
    private String realName;
    /**
     * 头部照片ID
     */
    @ApiModelProperty("头部照片ID")
    private String headerUrl;
    /**
     * 生日
     */
    @ApiModelProperty("生日")
    private Date birthTime;
    /**
     * 手机号码
     */
    @ApiModelProperty("手机号码")
    private String mobile;
    /**
     * 电话号码
     */
    @ApiModelProperty("电话号码")
    private String telephone;
    /**
     * 是否已经删除
     */
    @ApiModelProperty("是否已经删除")
    private Boolean isDeleted;
    /**
     * 头部特征
     */
    @ApiModelProperty("头部特征")
    private String headerInfo;
    /**
     * 特征版本
     */
    @ApiModelProperty("特征版本")
    private Integer faceVersion;
    /**
     * 特征版本
     */
    @ApiModelProperty("密码")
    private String nPw;

}