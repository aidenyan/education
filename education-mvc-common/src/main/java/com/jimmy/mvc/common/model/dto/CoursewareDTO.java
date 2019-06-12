package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("�μ���Ϣ")
public class CoursewareDTO extends BaseDTO {
    /**
     * �μ�������
     */
    @ApiModelProperty("�μ�������")
    private String name;
    /**
     * �Ƿ��Ѿ�ʹ��
     */
    @ApiModelProperty("�Ƿ��Ѿ�ʹ��")
    private Boolean isUsed;
    /**
     * �μ�������
     */
    @ApiModelProperty("�μ�������")
    private String description;


}