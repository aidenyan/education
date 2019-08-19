package com.jimmy.mvc.common.model.dto;

import com.jimmy.mvc.common.model.enums.AnswerTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel("�ش������")
public class AnswerDTO implements Serializable {

    /**
     * ������
     */
    @ApiModelProperty("������")
    private AnswerTypeEnum answerTypeEnum;
    /**
     * ͼֽ��ʱ
     */
    @ApiModelProperty("ͼֽ��ʱ")
    private List<BlueprintAnswerResultDTO> blueprintAnswerResultList;
    /**
     * ѡ�����ǵĴ�ID
     */
    @ApiModelProperty("ѡ�����ǵĴ�ID")
    private List<Long> selectIdList;

    /**
     * �ʴ���Ĵ�
     */
    @ApiModelProperty("�ʴ���Ĵ�")
    private String result;

}
