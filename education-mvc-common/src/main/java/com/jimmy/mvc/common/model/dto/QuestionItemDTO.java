package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

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
    private String content;
    /**
     * �Ƿ�δ��
     */
    @ApiModelProperty("�Ƿ�δ��")
    private Byte isResult;


}