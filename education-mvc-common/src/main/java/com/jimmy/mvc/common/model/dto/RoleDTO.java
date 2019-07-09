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
@ApiModel("角色信息")
public class RoleDTO extends BaseDTO {
    @ApiModelProperty("角色名字")
    private String name;
    @ApiModelProperty("角色描述")
    private String roleDesc;
    @ApiModelProperty("是否删除")
    private Boolean deleted;
}
