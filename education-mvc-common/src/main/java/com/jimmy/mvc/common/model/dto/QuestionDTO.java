package com.jimmy.mvc.common.model.dto;

import com.jimmy.common.utils.StringUtils;
import com.jimmy.mvc.common.model.enums.QuestionTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@ApiModel("问题的详细")
public class QuestionDTO extends BaseDTO {

    /**
     * 选择项
     */
    @ApiModelProperty("选择项")
    List<QuestionItemDTO> itemList;
    /**
     * 问题
     */
    @ApiModelProperty("问题")
    @NotBlank(message = "问题不能为空")
    private String question;
    /**
     * 问题类型0：问答题，1:单选题，2.多选题
     */
    @ApiModelProperty("问题类型")
    @NotNull(message = "问题类型不能为空")
    private QuestionTypeEnum type;
    /**
     * 非选择题则直接显示内容
     */
    @ApiModelProperty("非选择题则直接显示内容")
    private String result;
    /**
     * 是否删除
     */
    @ApiModelProperty("是否删除")
    private Boolean isDeleted;
    /**
     * 问题的节选
     */
    @ApiModelProperty("问题的节选")
    private String questionAbridge;

    public String getQuestionAbridge() {
        if (StringUtils.isBlank(question)) {
            return question;
        }
        if (question.length() > 15) {
            questionAbridge = question.substring(0, 15) + "...";
        } else {
            questionAbridge = question;
        }
        return questionAbridge;
    }
}