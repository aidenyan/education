package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Api("video��Ϣ")
public class VideoDTO {
    @ApiModelProperty("��Ƶ��URL")
    private String videoUrl;
    @ApiModelProperty("��ҳͼƬURl")
    private String imgUrl;
    @ApiModelProperty("��Ƶ�ı���")
    private String title;

}