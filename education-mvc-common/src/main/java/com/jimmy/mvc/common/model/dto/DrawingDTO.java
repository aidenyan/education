package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * ͼֽ�Ķ���
 */
@Data
@ApiModel("ͼֽ��Ϣ")
public class DrawingDTO {
    /**
     * ͼֽ��URL
     */
    @ApiModelProperty("ͼֽ��URL")
    private String drawingUrl;
    /**
     * ͼֽ�ı���
     */
    @ApiModelProperty("ͼֽ�ı���")
    private String name;
    /**
     * ͼֽ�Ĳ�������Ϣ
     */
    @ApiModelProperty("ͼֽ�Ĳ�������Ϣ�б�")
    private List<DrawingAnswerDTO> drawingAnswerList;

}
