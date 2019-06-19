package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: InteractiveDTO
 * @Description:
 * @author: aiden
 * @date: 2019/6/19/019.
 */
@Data
@ApiModel("������Ϣ")
public class InteractiveDTO {
    @ApiModelProperty("�����Ļ���ID")
    private Long machineId;
    @ApiModelProperty("����ʱ��Ҫ��������Ϣ")
    private String interactive;
}