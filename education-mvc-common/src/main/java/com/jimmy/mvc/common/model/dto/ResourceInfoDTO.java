package com.jimmy.mvc.common.model.dto;

import com.jimmy.mvc.common.model.enums.ResourceTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("资源信息")
public class ResourceInfoDTO extends BaseDTO {
    @ApiModelProperty("资源类型")
    private ResourceTypeEnum type;
    @ApiModelProperty("是否删除")
    private Boolean isDeleted;
    @ApiModelProperty("资源内容")
    private String content;
    @ApiModelProperty("资源内容对象")
    private Object contentObj;

}