package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * ͼֽ�Ĵ�
 */
@Data
@ApiModel("ͼֽ�Ĵ���Ϣ")
public class DrawingAnswerDTO {
    /**
     * �𰸵���ԴID
     */
    @ApiModelProperty("�𰸵���ԴID")
    private Long resourceId;
    /**
     * ͼֽ������
     */
    @ApiModelProperty("ͼֽ������")
    private String name;
    /**
     * ���������ĵ�λ��
     */
    @ApiModelProperty("���������ĵ�λ��")
    private BigDecimal measureCenter;
    /**
     * ����ֵ�ķ�Χ
     */
    @ApiModelProperty("����ֵ�ķ�Χ")
    private BigDecimal range;
    /**
     * ��Сֵ
     */
    @ApiModelProperty("��Сֵ")
    private BigDecimal min;
    /**
     * ���ֵ
     */
    @ApiModelProperty("���ֵ")
    private BigDecimal max;

}
