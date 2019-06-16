package com.jimmy.mvc.common.model.dto;

import com.jimmy.mvc.common.model.enums.FractionTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel("������Ϣ")
public class AppraiseItemDTO {
    @ApiModelProperty("�����������")
    private String name;
    @ApiModelProperty("�������ID")
    private Long id;
    @ApiModelProperty("��������")
    private FractionTypeEnum fractionType;
    @ApiModelProperty("����")
    private BigDecimal fraction;
}
