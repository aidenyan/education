package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 图纸的答案
 */
@Data
@ApiModel("图纸的答案信息")
public class DrawingAnswerDTO {
    /**
     * 答案的资源ID
     */
    @ApiModelProperty("答案的资源ID")
    private Long resourceId;
    /**
     * 图纸测量点
     */
    @ApiModelProperty("图纸测量点")
    private String name;
    /**
     * 测量点中心的位置
     */
    @ApiModelProperty("测量点中心的位置")
    private BigDecimal measureCenter;
    /**
     * 正负值的范围
     */
    @ApiModelProperty("正负值的范围")
    private BigDecimal range;
    /**
     * 最小值
     */
    @ApiModelProperty("最小值")
    private BigDecimal min;
    /**
     * 最大值
     */
    @ApiModelProperty("最大值")
    private BigDecimal max;

}
