package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("签到信息")
public class RegisterDTO {

    /**
     * 学生ID
     */
    @ApiModelProperty("学生ID")
    private Long studentId;
    /**
     * 课程ID
     */
    @ApiModelProperty("课程ID")
    private Long courseId;
    /**
     * 命令ID
     */
    @ApiModelProperty("命令ID")
    private Long commandId;



}