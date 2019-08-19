package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@Api("图纸信息")
public class BlueprintDTO {
    @ApiModelProperty("图纸的标题")
    private String title;
    @ApiModelProperty("图纸的URL")
    private String url;
    @ApiModelProperty("测试点")
    private List<BlueprintAnswerDTO> pointList;
}
