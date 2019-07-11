package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @ClassName: MachineStudentDTO
 * @Description:
 * @author: aiden
 * @date: 2019/6/12/012.
 */
@Data
@Api("������ѧ����ϵ��Ϣ")
public class MachineStudentDTO {
    /**
     * ����ID
     */
    @NotNull(message = "����ID����Ϊ��")
    @ApiModelProperty("����ID")
    private Long machineId;
    /**
     * �μ�ID
     */
    @NotNull(message = "�μ�ID����Ϊ��")
    @ApiModelProperty("�μ�ID")
    private Long courewareId;
    /**
     * ѧ���б�
     */
    @NotNull(message = "ѧ���б���Ϊ��")
    @ApiModelProperty("ѧ���б�")
    private List<Long> studentIdList;
}
