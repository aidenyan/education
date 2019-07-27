package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: RaiseHandDTO
 * @Description:
 * @author: aiden
 * @date: 2019/6/19/019.
 */
@Data
@Api("交互学生信息")
public class CommandStudentDTO {
    @ApiModelProperty("老师ID")
    private Long teacherId;
    @ApiModelProperty("机床ID")
    private Long machineId;
    @ApiModelProperty("学生ID")
    private Long studentId;
}
