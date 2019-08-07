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
@Api("字典内容的详细信息")
public class DictionaryItemDTO extends BaseDTO {
    /**
     * 评价的几项的字典
     */
    @ApiModelProperty("字典的ID")
    private Long dictionaryId;
    @ApiModelProperty("字典详细内容")
    private String content;
}
