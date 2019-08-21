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
@ApiModel("角色信息以及菜单信息")
public class RoleDetailDTO extends BaseDTO {
    @ApiModelProperty("角色基本信息")
    private RoleDTO roleDTO;
    @ApiModelProperty("菜单信息")
    private List<Long> menuIdList;

}
