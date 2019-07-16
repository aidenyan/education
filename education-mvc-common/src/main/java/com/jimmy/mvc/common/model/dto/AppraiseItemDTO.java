package com.jimmy.mvc.common.model.dto;

import com.jimmy.mvc.common.model.enums.FractionTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@ApiModel("评价信息")
public class AppraiseItemDTO {
    @NotNull(message ="评价项的名字不能为空" )
    @ApiModelProperty("评价项的名字")
    private String name;
    @NotNull(message ="评价项的ID不能为空" )
    @ApiModelProperty("评价项的ID")
    private Long id;
    @NotNull(message ="评价类型不能为空" )
    @ApiModelProperty("评价类型")
    private FractionTypeEnum fractionType;
    @NotNull(message ="评分数不能为空" )
    @ApiModelProperty("分数")
    private BigDecimal fraction;
}
