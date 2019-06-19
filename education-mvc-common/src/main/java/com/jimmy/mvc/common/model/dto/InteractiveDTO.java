package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: InteractiveDTO
 * @Description:
 * @author: aiden
 * @date: 2019/6/19/019.
 */
@Data
@ApiModel("交互信息")
public class InteractiveDTO {
    @ApiModelProperty("交互的机器ID")
    private Long machineId;
    @ApiModelProperty("交互时需要的链接信息")
    private String interactive;
}
