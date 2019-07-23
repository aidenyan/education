package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @ClassName: ClassMateDTO
 * @Description:
 * @author: aiden
 * @date: 2019/7/9/009.
 */
@Data
@ApiModel("班级信息")
public class ClassMateDTO extends BaseDTO {
    @NotBlank(message = "班级不能为空")
    @ApiModelProperty("班级名字")
    private String name;
    @ApiModelProperty("班级描述")
    private String description;
    @ApiModelProperty("班级编号")
    private String sn;
    @ApiModelProperty("是否删除")
    private Boolean isDeleted;
}
