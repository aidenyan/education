package com.jimmy.mvc.common.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class ClassRoomVoDTO {
    private ClassRoomDTO classRoomInfo;
    private List<MachineInfoDTO> machineInfoList;
}
