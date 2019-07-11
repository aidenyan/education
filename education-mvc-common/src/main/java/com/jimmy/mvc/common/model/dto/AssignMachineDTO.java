package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: AssignMachineDTO
 * @Description:
 * @author: aiden
 * @date: 2019/7/11/011.
 */
@Data
@Api("���������Ϣ�ӿ�")
public class AssignMachineDTO implements Serializable {
    private static final long serialVersionUID = -5007948109099568386L;
    @NotNull(message = "�γ�ID����Ϊ��")
    @ApiModelProperty("�γ�ID")
    private Long courseId;
    @ApiModelProperty("������ѧϰ��Ϣ�����ϵ")
    @NotEmpty(message = "������ѧϰ��Ϣ�����ϵ����Ϊ��")
    private List<MachineStudentDTO> machineStudentsList;
}
