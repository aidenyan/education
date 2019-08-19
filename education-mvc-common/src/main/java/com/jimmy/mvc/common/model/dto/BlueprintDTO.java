package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@Api("ͼֽ��Ϣ")
public class BlueprintDTO {
    @ApiModelProperty("ͼֽ�ı���")
    private String title;
    @ApiModelProperty("ͼֽ��URL")
    private String url;
    @ApiModelProperty("���Ե�")
    private List<BlueprintAnswerDTO> pointList;
}
