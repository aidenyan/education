package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.MachineInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MachineInfoMapper {
    /**
     * 保存机床信息
     *
     * @param record 机床信息
     * @return 保存数量
     */
    int insert(MachineInfo record);

    /**
     * 查找机床信息

     */
    MachineInfo findMachine(@Param("id")Long id, @Param("siteIdList") List<Long> siteIdList);
    /**
     * 查找教室的机床信息
     *
     * @param roomId 教室ID
     * @return List<机床信息>
     */

    List<MachineInfo> listByRoomId(@Param("roomId") Long roomId, @Param("siteIdList") List<Long> siteIdList);


    /**
     * 根据roomId删除
     *
     * @param roomId 教室ID
     * @return 删除数量
     */
    int deleteByRoomId(@Param("roomId") Long roomId, @Param("siteIdList") List<Long> siteIdList);
}