package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@ApiModel("�γ̵Ļش���Ϣ")
public class CourseAnswerDTO extends BaseDTO {

    /**
     * �γ�ID
     */
    @ApiModelProperty("�γ�ID")
    private Long courseId;
    /**
     * ����ID
     */
    @ApiModelProperty("����ID")
    private Long machineId;
    /**
     * �μ�ID
     */
    @ApiModelProperty("����ID")
    private Long coursewareId;
    /**
     * �μ���ϸID
     */
    @ApiModelProperty("�μ���ϸID")
    private Long coursewareItemId;
    /**
     * ����
     */
    @ApiModelProperty("����")
    private BigDecimal fraction;
    /**
     * ѧ���Ļش�
     */
    @ApiModelProperty("ѧ���Ļش�")
    private List<AnswerDTO> studentResult;
    /**
     * ��ʦ�Ļش�
     */
    @ApiModelProperty("��ʦ�Ļش�")
    private List<AnswerDTO> tearchResult;

}