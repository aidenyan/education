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
@Api("�ֵ���Ϣ")
public class DictionaryDTO extends BaseDTO{
    @ApiModelProperty("�ֵ������")
    private String name;
    @ApiModelProperty("�ֵ�ı��")
    private String sn;

    @ApiModelProperty("�ֵ������")
    private String description;

}
