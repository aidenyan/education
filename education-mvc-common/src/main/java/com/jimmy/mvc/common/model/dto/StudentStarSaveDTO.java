package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("本周之星信息")
public class StudentStarSaveDTO {
    /**
     * 学习之星
     */
    @ApiModelProperty("学习之星")
    private String starName;
    /**
     * 学生ID
     */
    @ApiModelProperty("学生ID")
    private Long studentId;
}
