package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Api("ͼֽ��ϸ��Ϣ")
public class BlueprintDetailDTO {
    @ApiModelProperty("ͼֽ��Ϣ")
    private BlueprintDTO blueprintDTO;
    @ApiModelProperty("ͼֽ����Ϣ")
    private BlueprintAnswerDTO blueprintAnswerDTO;
}
