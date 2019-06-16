package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("问题的选择项")
public class QuestionItemDTO extends BaseDTO {
    /**
     * 问题ID
     */
    @ApiModelProperty("问题ID")
    private Long questionId;
    /**
     * 选择项内容
     */
    @ApiModelProperty("选择项内容")
    private String content;
    /**
     * 是否未答案
     */
    @ApiModelProperty("是否未答案")
    private Byte isResult;


}