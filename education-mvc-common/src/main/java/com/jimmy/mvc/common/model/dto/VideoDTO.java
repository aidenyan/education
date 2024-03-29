package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Api("video信息")
public class VideoDTO {
    @ApiModelProperty("视频的URL")
    private String videoUrl;
    @ApiModelProperty("首页图片URl")
    private String imgUrl;
    @ApiModelProperty("视频的标题")
    private String title;

}
