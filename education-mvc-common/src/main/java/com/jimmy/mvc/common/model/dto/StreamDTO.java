package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
@ApiModel("数据流信息")
public class StreamDTO {
    @NotBlank(message = "数据流内容不能为空")
    @ApiModelProperty("数据流内容")
    private String content;
    @NotBlank(message = "文件的结尾类型不能为空")
    @ApiModelProperty("文件的结尾类型")
    private String type;
}
