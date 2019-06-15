package com.jimmy.mvc.common.model.dto;

import com.jimmy.mvc.common.model.enums.ResourceTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("��Դ��Ϣ")
public class ResourceInfoDTO extends BaseDTO {
    @ApiModelProperty("��Դ����")
    private ResourceTypeEnum type;
    @ApiModelProperty("�Ƿ�ɾ��")
    private Boolean isDeleted;
    @ApiModelProperty("��Դ����")
    private String content;
    @ApiModelProperty("��Դ���ݶ���")
    private Object contentObj;

}