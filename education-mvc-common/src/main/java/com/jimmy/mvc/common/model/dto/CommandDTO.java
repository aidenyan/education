package com.jimmy.mvc.common.model.dto;

import com.jimmy.mvc.common.model.enums.CommandTypeEnum;
import com.jimmy.mvc.common.model.enums.DirectionEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("命令信息")
public class CommandDTO extends BaseDTO {
    /**
     * 课程ID
     */
    @ApiModelProperty("课程ID")
    private Long courseId;

    /**
     * 发送的人
     */
    @ApiModelProperty(value = "发送的人", hidden = true)
    private String operationName;

    /**
     * 发送的人ID
     */
    @ApiModelProperty(value = "发送的人ID", hidden = true)
    private Long operationId;
    /**
     * 指令类型
     */
    @ApiModelProperty(value = "指令类型")
    private CommandTypeEnum commandType;
    /**
     * 方向
     */
    @ApiModelProperty(value = "方向", hidden = true)
    private DirectionEnum direction;
    /**
     * SN
     */
    @ApiModelProperty(value = "SN", hidden = true)
    private String sn;
    /**
     * 指令内容
     */
    @ApiModelProperty(value = "指令内容")
    private String content;




}