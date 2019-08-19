package com.jimmy.mvc.common.model.dto;

import com.jimmy.mvc.common.model.enums.AnswerTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel("回答的内容")
public class AnswerDTO implements Serializable {

    /**
     * 答案类型
     */
    @ApiModelProperty("答案类型")
    private AnswerTypeEnum answerTypeEnum;
    /**
     * 图纸答案时
     */
    @ApiModelProperty("图纸答案时")
    private List<BlueprintAnswerResultDTO> blueprintAnswerResultList;
    /**
     * 选择提是的答案ID
     */
    @ApiModelProperty("选择提是的答案ID")
    private List<Long> selectIdList;

    /**
     * 问答题的答案
     */
    @ApiModelProperty("问答题的答案")
    private String result;

}
