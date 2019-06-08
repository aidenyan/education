package com.jimmy.service;

import com.jimmy.dao.entity.ClassRoomInfo;
import com.jimmy.dao.entity.MachineInfo;
import com.jimmy.model.dto.ClassRoomDTO;

import java.util.List;

public interface ClassRoomService {
    /**
     * 根据名字搜索教室
     *
     * @param name 名字
     * @return List<教室>
     */
    List<ClassRoomInfo> list(String name);

    /**
     * 保存教室和机床信息
     *
     * @param classRoomInfo   教室信息
     * @param machineInfoList 机床信息
     */
    void save(ClassRoomInfo classRoomInfo, List<MachineInfo> machineInfoList);

    /**
     * 根据roomID查找教室信息
     *
     * @param roomId 教室ID
     * @return 教室和机床信息
     */
    ClassRoomDTO find(Long roomId);

    /**
     * 删除教室信息
     *
     * @param roomId 教室ID
     */
    void deleted(Long roomId);
}
