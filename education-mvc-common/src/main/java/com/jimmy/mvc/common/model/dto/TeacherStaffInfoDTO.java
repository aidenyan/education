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
@ApiModel("��ʦ�Ļ�����Ϣ")
public class TeacherStaffInfoDTO extends BaseDTO {
    /**
     * IC��
     */
    @ApiModelProperty("IC��")
    private String idCard;
    @NotBlank(message = "��ʦ����������Ϊ��" )
    @ApiModelProperty("��ʦ������")
    private String name;

    @NotNull(message = "��ʦ����������Ϊ��" )
    @ApiModelProperty("�Ա�0:��ʾ�У�1:��ʾŮ")
    private SexEnum sex;

    @NotNull(message = "ְλ���Ͳ���Ϊ��" )
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
    @ApiModelProperty("��ɫID")
    @NotEmpty(message = "��ɫ����Ϊ��")
    private List<Long> roleIdList;
    @ApiModelProperty("��ʦ�ϵĿν���")
    private Long appRoomId;
    /**
     * �����汾
     */
    @ApiModelProperty("�����汾")
    private Integer faceVersion;
}