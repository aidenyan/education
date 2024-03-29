package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Api("图纸回答信息")
public class BlueprintAnswerDTO {
    @ApiModelProperty("答案信息")
    private Double answer;
    @ApiModelProperty("测试点内容")
    private String pointName;
    @ApiModelProperty("下公差")
    private Double minError;
    @ApiModelProperty("上公差")
    private Double maxError;
    @ApiModelProperty("单位")
    private String unit;
}
