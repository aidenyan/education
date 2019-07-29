package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("�γ���ϸ��Ϣ")
public class StudentDetailDTO {
    @ApiModelProperty("ѧ������Ϣ")
    private StudentInfoDTO studentInfoDTO;
    @ApiModelProperty("�Ƿ�ע��")
    private Boolean isRegister;
    @ApiModelProperty("�Ƿ����")
    private Boolean isAskLevel;
    @ApiModelProperty("��������")
    private Long machineId;
}
