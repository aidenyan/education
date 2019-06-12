package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("机床信息")
public class MachineInfoDTO extends BaseDTO {
    /**
     * 教室ID
     */
    @ApiModelProperty("教室ID")
    private Long roomId;
    /**
     * 编号
     */
    @ApiModelProperty("编号")
    private String sn;
    /**
     * 行数
     */
    @ApiModelProperty("行数")
    private Integer rowNum;
    /**
     * 列数
     */
    @ApiModelProperty("列数")
    private Integer columnNum;


}