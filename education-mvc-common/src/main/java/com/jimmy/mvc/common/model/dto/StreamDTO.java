package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
@ApiModel("��������Ϣ")
public class StreamDTO {
    @NotBlank(message = "���������ݲ���Ϊ��")
    @ApiModelProperty("����������")
    private String content;
    @NotBlank(message = "�ļ��Ľ�β���Ͳ���Ϊ��")
    @ApiModelProperty("�ļ��Ľ�β����")
    private String type;
}
