package com.jimmy.mvc.common.model.dto;

import com.jimmy.mvc.common.model.enums.ResourceTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@Data
@ApiModel("��Դ��Ϣ")
public class ResourceInfoDTO extends BaseDTO {
    @NotNull(message = "��Դ���Ͳ���δ��")
    @ApiModelProperty("��Դ����")
    private ResourceTypeEnum type;
    @ApiModelProperty("�Ƿ�ɾ��")
    private Boolean isDeleted;
    @NotBlank(message = "��Դ���ݲ���δ��")
    @ApiModelProperty("��Դ����")
    private String content;
    @ApiModelProperty("��Դ���ݶ���")
    private Object contentObj;

}