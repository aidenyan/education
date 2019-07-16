package com.jimmy.mvc.common.model.dto;

import com.jimmy.mvc.common.model.enums.FractionTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@ApiModel("������Ϣ")
public class AppraiseItemDTO {
    @NotNull(message ="����������ֲ���Ϊ��" )
    @ApiModelProperty("�����������")
    private String name;
    @NotNull(message ="�������ID����Ϊ��" )
    @ApiModelProperty("�������ID")
    private Long id;
    @NotNull(message ="�������Ͳ���Ϊ��" )
    @ApiModelProperty("��������")
    private FractionTypeEnum fractionType;
    @NotNull(message ="����������Ϊ��" )
    @ApiModelProperty("����")
    private BigDecimal fraction;
}
