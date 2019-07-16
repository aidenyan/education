package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @ClassName: InteractiveDTO
 * @Description:
 * @author: aiden
 * @date: 2019/6/19/019.
 */
@Data
@ApiModel("交互信息")
public class InteractiveDTO {
    @NotNull(message = "交互的机器ID不能为空")
    @ApiModelProperty("交互的机器ID")
    private Long machineId;
    @NotBlank(message = "交互的机器链接信息不能为空")
    @ApiModelProperty("交互时需要的链接信息")
    private String interactive;
}
