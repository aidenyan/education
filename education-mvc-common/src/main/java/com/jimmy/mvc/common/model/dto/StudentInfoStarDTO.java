package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("����֮����Ϣ")
public class StudentInfoStarDTO extends StudentInfoDTO {
    /**
     * ѧϰ֮��
     */
    @ApiModelProperty("ѧϰ֮��")
    private String starName;
}
