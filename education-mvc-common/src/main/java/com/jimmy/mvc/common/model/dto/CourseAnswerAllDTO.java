package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("单个机器回答的信息")
public class CourseAnswerAllDTO {

    @ApiModelProperty("机床ID")
    private Long machineId;
    @ApiModelProperty("老师的答案信息")
    private List<CourseAnswerDTO> courseAnswerDTOList;
}
