package com.jimmy.model.dto;

import com.jimmy.dao.entity.ClassRoomInfo;
import com.jimmy.dao.entity.MachineInfo;
import lombok.Data;

import java.util.List;

@Data
public class ClassRoomDTO {
    private ClassRoomInfo classRoomInfo;
    private List<MachineInfo> machineInfoList;
}
