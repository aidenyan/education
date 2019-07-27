package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("机场分配信息")
public class MachineAssignDTO {
    @ApiModelProperty("机床信息")
    private Long machineId;
    @ApiModelProperty("分配的学生信息")
    private List<Long> studentIdList;
}
