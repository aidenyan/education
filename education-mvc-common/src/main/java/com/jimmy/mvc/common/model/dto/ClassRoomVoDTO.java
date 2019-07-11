package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Api("���ҵ���ϸ��Ϣ")
public class ClassRoomVoDTO {
    @ApiModelProperty("���ҵĻ�����Ϣ")
    @NotNull(message = "���ҵĻ�����Ϣ����Ϊ��")
    private ClassRoomDTO classRoomInfo;
    @ApiModelProperty("���ҵĻ�����Ϣ�б�")
    @NotEmpty(message = "���ҵĻ�����Ϣ�б���Ϊ��")
    private List<MachineInfoDTO> machineInfoList;
}
