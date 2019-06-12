package com.jimmy.model.dto;

import com.jimmy.dao.entity.ClassRoomInfo;
import com.jimmy.dao.entity.MachineInfo;
import lombok.Data;

import java.util.List;

@Data
public class ClassRoomVO {
    private ClassRoomInfo classRoomInfo;
    private List<MachineInfo> machineInfoList;
}
