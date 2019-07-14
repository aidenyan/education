package com.jimmy.mvc.common.model.dto;

import com.jimmy.mvc.common.model.enums.ResourceTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@Data
@ApiModel("资源信息")
public class ResourceInfoDTO extends BaseDTO {
    @NotNull(message = "资源类型不能未空")
    @ApiModelProperty("资源类型")
    private ResourceTypeEnum type;
    @ApiModelProperty("是否删除")
    private Boolean isDeleted;
    @NotBlank(message = "资源内容不能未空")
    @ApiModelProperty("资源内容")
    private String content;
    @ApiModelProperty("资源内容对象")
    private Object contentObj;

}