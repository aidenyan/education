package com.jimmy.mvc.common.model.dto;

import com.jimmy.dao.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("�γ���Ϣ")
public class CourseInfoDTO extends BaseDTO {

    /**
     * �γ̵�����
     */
    @ApiModelProperty("�γ̵�����")
    private String name;
    /**
     * �γ̿�ʼʱ��
     */
    @ApiModelProperty("�γ̿�ʼʱ��")
    private Date startTime;
    /**
     * �γ�ʱ�䳤��
     */
    @ApiModelProperty("�γ�ʱ�䳤��")
    private Integer timeLong;
    /**
     * ����ID
     */
    @ApiModelProperty("����ID")
    private Long roomId;
    /**
     * ��ʦID
     */
    @ApiModelProperty("��ʦID")
    private Long teacherId;
    /**
     * �Ƿ��Ѿ�ʹ��
     */
    @ApiModelProperty("�Ƿ��Ѿ�ʹ��")
    private Boolean isUsed;
    /**
     * ����
     */
    @ApiModelProperty("����")
    private String description;

}