package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("����֮����Ϣ")
public class StudentStarSaveDTO {
    /**
     * ѧϰ֮��
     */
    @ApiModelProperty("ѧϰ֮��")
    private String starName;
    /**
     * ѧ��ID
     */
    @ApiModelProperty("ѧ��ID")
    private Long studentId;
}
