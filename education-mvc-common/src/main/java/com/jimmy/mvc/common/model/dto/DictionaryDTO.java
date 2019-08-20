package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: DictionaryDTO
 * @Description:
 * @author: aiden
 * @date: 2019/8/7/007.
 */
@Data
@Api("字典信息")
public class DictionaryDTO extends BaseDTO{
    @ApiModelProperty("字典的名字")
    private String name;
    @ApiModelProperty("字典的编号")
    private String sn;

    @ApiModelProperty("字典的描述")
    private String description;

}
