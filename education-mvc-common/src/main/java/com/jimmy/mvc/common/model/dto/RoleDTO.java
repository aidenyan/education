package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: RoleDTO
 * @Description:
 * @author: aiden
 * @date: 2019/7/9/009.
 */
@Data
@ApiModel("��ɫ��Ϣ")
public class RoleDTO extends BaseDTO {
    @ApiModelProperty("��ɫ����")
    private String name;
    @ApiModelProperty("��ɫ����")
    private String roleDesc;
    @ApiModelProperty("�Ƿ�ɾ��")
    private Boolean deleted;
}
