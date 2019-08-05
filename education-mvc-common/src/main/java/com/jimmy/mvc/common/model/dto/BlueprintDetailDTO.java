package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@Api("图纸详细信息")
public class BlueprintDetailDTO {
    @ApiModelProperty("图纸信息")
    private BlueprintDTO blueprintDTO;
    @ApiModelProperty("图纸答案信息列表")
    private List<BlueprintAnswerDTO> blueprintAnswerDTOList;
}
