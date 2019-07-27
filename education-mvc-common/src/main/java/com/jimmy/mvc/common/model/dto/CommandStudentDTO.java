package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: RaiseHandDTO
 * @Description:
 * @author: aiden
 * @date: 2019/6/19/019.
 */
@Data
@Api("����ѧ����Ϣ")
public class CommandStudentDTO {
    @ApiModelProperty("��ʦID")
    private Long teacherId;
    @ApiModelProperty("����ID")
    private Long machineId;
    @ApiModelProperty("ѧ��ID")
    private Long studentId;
}
