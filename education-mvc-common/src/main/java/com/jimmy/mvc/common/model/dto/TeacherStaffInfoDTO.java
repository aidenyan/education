package com.jimmy.mvc.common.model.dto;

import com.jimmy.mvc.common.model.enums.SexEnum;
import com.jimmy.mvc.common.model.enums.StaffTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@ApiModel("老师的基本信息")
public class TeacherStaffInfoDTO extends BaseDTO {
    /**
     * IC卡
     */
    @ApiModelProperty("IC卡")
    private String idCard;
    @NotBlank(message = "老师的姓名不能为空" )
    @ApiModelProperty("老师的姓名")
    private String name;

    @NotNull(message = "老师的姓名不能为空" )
    @ApiModelProperty("性别：0:表示男，1:表示女")
    private SexEnum sex;

    @NotNull(message = "职位类型不能为空" )
    @ApiModelProperty("职位类型，0:校长，1:老师")
    private StaffTypeEnum staffType;
    @ApiModelProperty("职位名称")
    private String staffName;
    @ApiModelProperty("邮件")
    private String email;
    @ApiModelProperty("是否可用")
    private Boolean isEnabled;
    @ApiModelProperty("是否已经锁定")
    private Boolean isLocked;

    @ApiModelProperty("锁定时间")
    private Date lockedDate;
    @ApiModelProperty("登录时间")
    private Date loginDate;
    @ApiModelProperty("失败次数")
    private Integer loginFailureCount;
    @ApiModelProperty("登录IP")
    private String loginIp;
    @ApiModelProperty("真实的姓名")
    private String realName;
    @ApiModelProperty("头像图片")
    private String headerUrl;
    @ApiModelProperty("生日")
    private Date birthTime;
    @ApiModelProperty("手机号码")
    private String mobile;
    @ApiModelProperty("电话号码")
    private String telephone;
    @ApiModelProperty("是否删除")
    private Boolean isDeleted;
    @ApiModelProperty("头像特征信息")
    private String headerInfo;
    @ApiModelProperty("角色ID")
    @NotEmpty(message = "角色不能为空")
    private List<Long> roleIdList;
    @ApiModelProperty("老师上的课教室")
    private Long appRoomId;
    /**
     * 特征版本
     */
    @ApiModelProperty("特征版本")
    private Integer faceVersion;

    private String npw;
}