package com.jimmy.model.vo;

import com.jimmy.dao.entity.ClassRoomInfo;
import com.jimmy.dao.entity.MachineInfo;
import lombok.Data;

import java.util.List;

@Data
public class ClassRoomVO {
    private ClassRoomInfo classRoomInfo;
    private List<MachineInfo> machineInfoList;
}
