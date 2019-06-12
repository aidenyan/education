package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("课件信息")
public class CoursewareDTO extends BaseDTO {
    /**
     * 课件的名字
     */
    @ApiModelProperty("课件的名字")
    private String name;
    /**
     * 是否已经使用
     */
    @ApiModelProperty("是否已经使用")
    private Boolean isUsed;
    /**
     * 课件的描述
     */
    @ApiModelProperty("课件的描述")
    private String description;


}