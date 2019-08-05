package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Api("图片word文档以及文本")
public class ResoureceStrDTO {
    @ApiModelProperty("具体内容")
    private String content;
    @ApiModelProperty("标题")
    private String title;
}
