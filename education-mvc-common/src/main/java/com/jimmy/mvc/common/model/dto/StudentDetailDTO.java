package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("课程详细信息")
public class StudentDetailDTO {
    @ApiModelProperty("学生的信息")
    private StudentInfoDTO studentInfoDTO;
    @ApiModelProperty("是否命令")
    private Boolean isRegister;
    @ApiModelProperty("是否请假")
    private Boolean isAskLevel;
    @ApiModelProperty("所属机床")
    private Long machineId;
    @ApiModelProperty("课程的名字")
    private String courseName;
    @ApiModelProperty("课程的Id")
    private Long courseId;
    @ApiModelProperty("签到命令ID")
    private Long registerCommandId;
}
