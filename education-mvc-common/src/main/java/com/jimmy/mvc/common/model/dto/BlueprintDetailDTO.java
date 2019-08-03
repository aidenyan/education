package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Api("图纸详细信息")
public class BlueprintDetailDTO {
    @ApiModelProperty("图纸信息")
    private BlueprintDTO blueprintDTO;
    @ApiModelProperty("图纸答案信息")
    private BlueprintAnswerDTO blueprintAnswerDTO;
}
