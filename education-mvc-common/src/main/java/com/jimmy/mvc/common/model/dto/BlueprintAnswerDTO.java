package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Api("图纸回答信息")
public class BlueprintAnswerDTO {

    @ApiModelProperty("答案信息")
    private Double answer;


    @ApiModelProperty("误差")
    private Double error;

    @ApiModelProperty("单位")
    private String unit;
}
