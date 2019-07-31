package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("�γ���ϸ��Ϣ")
public class StudentDetailDTO {
    @ApiModelProperty("ѧ������Ϣ")
    private StudentInfoDTO studentInfoDTO;
    @ApiModelProperty("�Ƿ�����")
    private Boolean isRegister;
    @ApiModelProperty("�Ƿ����")
    private Boolean isAskLevel;
    @ApiModelProperty("��������")
    private Long machineId;
    @ApiModelProperty("�γ̵�����")
    private String courseName;
    @ApiModelProperty("�γ̵�Id")
    private Long courseId;
    @ApiModelProperty("ǩ������ID")
    private Long registerCommandId;
}
