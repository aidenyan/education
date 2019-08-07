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
@Api("�ֵ����ݵ���ϸ��Ϣ")
public class DictionaryItemDTO extends BaseDTO {
    /**
     * ���۵ļ�����ֵ�
     */
    @ApiModelProperty("�ֵ��ID")
    private Long dictionaryId;
    @ApiModelProperty("�ֵ���ϸ����")
    private String content;
}
