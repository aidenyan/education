package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Api("ͼƬword�ĵ��Լ��ı�")
public class ResoureceStrDTO {
    @ApiModelProperty("��������")
    private String content;
    @ApiModelProperty("����")
    private String title;
}
