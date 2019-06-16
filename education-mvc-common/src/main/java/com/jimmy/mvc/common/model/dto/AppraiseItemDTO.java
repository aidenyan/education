package com.jimmy.mvc.common.model.dto;

import com.jimmy.mvc.common.model.enums.FractionTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel("评价信息")
public class AppraiseItemDTO {
    @ApiModelProperty("评价项的名字")
    private String name;
    @ApiModelProperty("评价项的ID")
    private Long id;
    @ApiModelProperty("评价类型")
    private FractionTypeEnum fractionType;
    @ApiModelProperty("分数")
    private BigDecimal fraction;
}
