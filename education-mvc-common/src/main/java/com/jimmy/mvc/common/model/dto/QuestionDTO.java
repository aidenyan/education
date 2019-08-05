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
@ApiModel("�������ϸ")
public class QuestionDTO extends BaseDTO {

    /**
     * ѡ����
     */
    @ApiModelProperty("ѡ����")
    List<QuestionItemDTO> itemList;
    /**
     * ����
     */
    @ApiModelProperty("����")
    @NotBlank(message = "���ⲻ��Ϊ��")
    private String question;
    /**
     * ��������0���ʴ��⣬1:��ѡ�⣬2.��ѡ��
     */
    @ApiModelProperty("��������")
    @NotNull(message = "�������Ͳ���Ϊ��")
    private QuestionTypeEnum type;
    /**
     * ��ѡ������ֱ����ʾ����
     */
    @ApiModelProperty("��ѡ������ֱ����ʾ����")
    private String result;
    /**
     * �Ƿ�ɾ��
     */
    @ApiModelProperty("�Ƿ�ɾ��")
    private Boolean isDeleted;
    /**
     * ����Ľ�ѡ
     */
    @ApiModelProperty("����Ľ�ѡ")
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