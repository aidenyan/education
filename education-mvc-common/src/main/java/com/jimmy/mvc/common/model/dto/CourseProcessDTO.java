package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@Data
@ApiModel("课程信息信息")
public class CourseProcessDTO {

    @NotNull(message = "课件详细信息ID不能为空")
    @ApiModelProperty("课件详细信息ID")
    private Long coursewareItemId;
    @NotBlank(message = "课件详细信息名字不能为空")
    @ApiModelProperty("课件详细信息名字")
    private String coursewareItemName;
    @NotNull(message = "步数不能为空")
    @ApiModelProperty("步数")
    private Integer stepNum;
    @ApiModelProperty("机床ID不用填写")
    private Long machineId;


}