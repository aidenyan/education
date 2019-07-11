package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

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
    @NotBlank(message = "机床编号不能为空")
    private String sn;
    /**
     * 行数
     */
    @ApiModelProperty("行数")
    @NotNull(message = "行数不能为空")
    private Integer rowNum;
    /**
     * 列数
     */
    @ApiModelProperty("列数")
    @NotNull(message = "列数不能为空")
    private Integer columnNum;


}