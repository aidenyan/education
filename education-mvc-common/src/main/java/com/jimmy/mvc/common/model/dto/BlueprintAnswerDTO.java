package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Api("ͼֽ�ش���Ϣ")
public class BlueprintAnswerDTO {
    @ApiModelProperty("����Ϣ")
    private Double answer;
    @ApiModelProperty("���Ե�����")
    private String pointName;
    @ApiModelProperty("�¹���")
    private Double minError;
    @ApiModelProperty("�Ϲ���")
    private Double maxError;
    @ApiModelProperty("��λ")
    private String unit;
}
