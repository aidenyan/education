package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Api("��Ƶ����Ϣ")
public class VideoDTO {
    @ApiModelProperty("��Ƶ��URL")
    private String videoUrl;
    @ApiModelProperty("��ҳͼƬURl")
    private String imgUrl;

}
