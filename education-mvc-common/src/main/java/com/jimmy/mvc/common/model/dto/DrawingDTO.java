package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 图纸的对象
 */
@Data
@ApiModel("图纸信息")
public class DrawingDTO {
    /**
     * 图纸的URL
     */
    @ApiModelProperty("图纸的URL")
    private String drawingUrl;
    /**
     * 图纸的标题
     */
    @ApiModelProperty("图纸的标题")
    private String name;
    /**
     * 图纸的测量点信息
     */
    @ApiModelProperty("图纸的测量点信息列表")
    private List<DrawingAnswerDTO> drawingAnswerList;

}
