package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Api("图纸回答信息")
public class BlueprintAnswerResultDTO {

    @ApiModelProperty("答案信息")
    private Double answer;
    @ApiModelProperty("测试点内容")
    private String pointName;
    /**
     * 是否正确
     */
    @ApiModelProperty("是否正确")
    private boolean isResult;


}
