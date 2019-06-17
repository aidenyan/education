package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("ǩ����Ϣ")
public class RegisterDTO {

    /**
     * ѧ��ID
     */
    @ApiModelProperty("ѧ��ID")
    private Long studentId;
    /**
     * �γ�ID
     */
    @ApiModelProperty("�γ�ID")
    private Long courseId;
    /**
     * ����ID
     */
    @ApiModelProperty("����ID")
    private Long commandId;



}