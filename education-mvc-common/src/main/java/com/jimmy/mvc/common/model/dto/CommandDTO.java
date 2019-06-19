package com.jimmy.mvc.common.model.dto;

import com.jimmy.mvc.common.model.enums.CommandTypeEnum;
import com.jimmy.mvc.common.model.enums.DirectionEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("������Ϣ")
public class CommandDTO extends BaseDTO {
    /**
     * �γ�ID
     */
    @ApiModelProperty("�γ�ID")
    private Long courseId;

    /**
     * ���͵���
     */
    @ApiModelProperty(value = "���͵���", hidden = true)
    private String operationName;

    /**
     * ���͵���ID
     */
    @ApiModelProperty(value = "���͵���ID", hidden = true)
    private Long operationId;
    /**
     * ָ������
     */
    @ApiModelProperty(value = "ָ������")
    private CommandTypeEnum commandType;
    /**
     * ����
     */
    @ApiModelProperty(value = "����", hidden = true)
    private DirectionEnum direction;
    /**
     * SN
     */
    @ApiModelProperty(value = "SN", hidden = true)
    private String sn;
    /**
     * ָ������
     */
    @ApiModelProperty(value = "ָ������")
    private String content;




}