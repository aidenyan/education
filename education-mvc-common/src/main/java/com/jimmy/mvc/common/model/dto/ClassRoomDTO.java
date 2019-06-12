package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("������Ϣ")
public class ClassRoomDTO extends BaseDTO {
    /**
     * ���ұ��
     */
    @ApiModelProperty("���ұ��")
    private String sn;
    /**
     * ��������
     */
    @ApiModelProperty("��������")
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