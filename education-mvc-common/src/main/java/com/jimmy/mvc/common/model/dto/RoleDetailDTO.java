package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @ClassName: RoleDTO
 * @Description:
 * @author: aiden
 * @date: 2019/7/9/009.
 */
@Data
@ApiModel("��ɫ��Ϣ�Լ��˵���Ϣ")
public class RoleDetailDTO extends BaseDTO {
    @ApiModelProperty("��ɫ������Ϣ")
    private RoleDTO roleDTO;
    @ApiModelProperty("�˵���Ϣ")
    private List<Long> menuIdList;

}
