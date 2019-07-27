package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("����������Ϣ")
public class MachineAssignDTO {
    @ApiModelProperty("������Ϣ")
    private Long machineId;
    @ApiModelProperty("�����ѧ����Ϣ")
    private List<Long> studentIdList;
}
