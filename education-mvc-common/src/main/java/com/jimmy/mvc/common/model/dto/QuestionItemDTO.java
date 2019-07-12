package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@Data
@ApiModel("�����ѡ����")
public class QuestionItemDTO extends BaseDTO {
    /**
     * ����ID
     */
    @ApiModelProperty("����ID")
    private Long questionId;
    /**
     * ѡ��������
     */
    @ApiModelProperty("ѡ��������")
    @NotBlank(message = "ѡ�������ݲ���Ϊ��")
    private String content;
    /**
     * �Ƿ�δ��
     */
    @ApiModelProperty("�Ƿ�δ��")
    @NotNull(message = "�Ƿ�δ�𰸲���Ϊ��")
    private Boolean isResult;


}