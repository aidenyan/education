package com.jimmy.mvc.common.model.dto;

import com.jimmy.dao.entity.CourseStudentProcess;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("ѧ��������Ϣ")
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
    @ApiModelProperty("����������Ϣ")
    private CourseStudentProcessRestartDTO process;
}
