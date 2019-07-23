package com.jimmy.mvc.common.model.dto;

import com.jimmy.dao.entity.BaseEntity;
import com.jimmy.mvc.common.model.enums.SexEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("ѧ��������Ϣ")
public class StudentInfoDTO extends BaseDTO {
    /**
     * IC��
     */
    @ApiModelProperty("IC��")
    private String idCard;
    /**
     * �༶ID
     */
    @ApiModelProperty("�༶ID")
    private Long classmateId;
    /**
     * �༶����
     */
    @ApiModelProperty("�༶����")
    private String classmateName;
    /**
     * ����
     */
    @ApiModelProperty("����")
    private String name;
    /**
     * �Ա�
     */
    @ApiModelProperty("�Ա�")
    private SexEnum sex;
    /**
     * email
     */
    @ApiModelProperty("email")
    private String email;
    /**
     * �Ƿ���Ч
     */
    @ApiModelProperty("�Ƿ���Ч")
    private Boolean isEnabled;
    /**
     * ��ʵ������
     */
    @ApiModelProperty("��ʵ������")
    private String realName;
    /**
     * ͷ����ƬID
     */
    @ApiModelProperty("ͷ����ƬID")
    private String headerUrl;
    /**
     * ����
     */
    @ApiModelProperty("����")
    private Date birthTime;
    /**
     * �ֻ�����
     */
    @ApiModelProperty("�ֻ�����")
    private String mobile;
    /**
     * �绰����
     */
    @ApiModelProperty("�绰����")
    private String telephone;
    /**
     * �Ƿ��Ѿ�ɾ��
     */
    @ApiModelProperty("�Ƿ��Ѿ�ɾ��")
    private Boolean isDeleted;
    /**
     * ͷ������
     */
    @ApiModelProperty("ͷ������")
    private String headerInfo;
    /**
     * �����汾
     */
    @ApiModelProperty("�����汾")
    private Integer faceVersion;
    /**
     * �����汾
     */
    @ApiModelProperty("����")
    private String nPw;

}