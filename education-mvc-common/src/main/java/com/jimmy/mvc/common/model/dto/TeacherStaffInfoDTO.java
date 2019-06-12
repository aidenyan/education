package com.jimmy.mvc.common.model.dto;

import com.jimmy.mvc.common.model.enums.SexEnum;
import com.jimmy.mvc.common.model.enums.StaffTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("��ʦ�Ļ�����Ϣ")
public class TeacherStaffInfoDTO extends BaseDTO {

    @ApiModelProperty("��ʦ������")
    private String name;
    @ApiModelProperty("�Ա�0:��ʾ�У�1:��ʾŮ")
    private SexEnum sex;
    @ApiModelProperty("ְλ���ͣ�0:У����1:��ʦ")
    private StaffTypeEnum staffType;
    @ApiModelProperty("ְλ����")
    private String staffName;
    @ApiModelProperty("�ʼ�")
    private String email;
    @ApiModelProperty("�Ƿ����")
    private Boolean isEnabled;
    @ApiModelProperty("�Ƿ��Ѿ�����")
    private Boolean isLocked;

    @ApiModelProperty("����ʱ��")
    private Date lockedDate;
    @ApiModelProperty("��¼ʱ��")
    private Date loginDate;
    @ApiModelProperty("ʧ�ܴ���")
    private Integer loginFailureCount;
    @ApiModelProperty("��¼IP")
    private String loginIp;
    @ApiModelProperty("��ʵ������")
    private String realName;
    @ApiModelProperty("ͷ��ͼƬ")
    private String headerUrl;
    @ApiModelProperty("����")
    private Date birthTime;
    @ApiModelProperty("�ֻ�����")
    private String mobile;
    @ApiModelProperty("�绰����")
    private String telephone;
    @ApiModelProperty("�Ƿ�ɾ��")
    private Boolean isDeleted;
    @ApiModelProperty("ͷ��������Ϣ")
    private String headerInfo;
    @ApiModelProperty("��ʦID")
    private Long roomId;
}