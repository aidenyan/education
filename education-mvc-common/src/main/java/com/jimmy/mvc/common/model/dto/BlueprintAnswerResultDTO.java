package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Api("ͼֽ�ش���Ϣ")
public class BlueprintAnswerResultDTO {

    @ApiModelProperty("����Ϣ")
    private Double answer;
    @ApiModelProperty("���Ե�����")
    private String pointName;
    /**
     * �Ƿ���ȷ
     */
    @ApiModelProperty("�Ƿ���ȷ")
    private boolean isResult;


}