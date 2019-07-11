package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@Data
@ApiModel("������Ϣ")
public class ClassRoomDTO extends BaseDTO {
    /**
     * ���ұ��
     */
    @ApiModelProperty("���ұ��")
    @NotBlank(message = "���ұ�Ų���Ϊ��")
    private String sn;
    /**
     * ��������
     */
    @ApiModelProperty("��������")
    @NotBlank(message = "�������ֲ���Ϊ��")
    private String name;
    /**
     * ���Ҿ����ַ
     */
    @ApiModelProperty("���Ҿ����ַ")
    private String address;
    /**
     * �Ƿ��Ѿ�ɾ��
     */
    @ApiModelProperty("�Ƿ��Ѿ�ɾ��")
    private Boolean isDeleted;
    /**
     * ����
     */
    @ApiModelProperty("����")
    private String description;


}