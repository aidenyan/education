package com.jimmy.mvc.common.model.dto;

import com.jimmy.mvc.common.model.enums.QuestionTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("������Ϣ")
public class QuestionDTO extends BaseDTO {

    /**
     * ����
     */
    @ApiModelProperty("����")
    private String question;
    /**
     * ��������0���ʴ��⣬1:��ѡ�⣬2.��ѡ��
     */
    @ApiModelProperty("��������")
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
     * ѡ����
     */
    @ApiModelProperty("ѡ����")
    List<QuestionItemDTO> itemList;

}