package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("���������ش����Ϣ")
public class CourseAnswerAllDTO {

    @ApiModelProperty("����ID")
    private Long machineId;
    @ApiModelProperty("��ʦ�Ĵ���Ϣ")
    private List<CourseAnswerDTO> courseAnswerDTOList;
}
