package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Api("ͼֽ�ش���Ϣ")
public class BlueprintAnswerDTO {
    @ApiModelProperty("�𰸱���")
    private String title;
    @ApiModelProperty("����Ϣ")
    private Double answer;
    @ApiModelProperty("���Ե�����")
    private String pointName;
    @ApiModelProperty("���")
    private Double error;

    @ApiModelProperty("��λ")
    private String unit;
}
