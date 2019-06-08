package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.ClassRoomInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassRoomInfoMapper {

    /**
     * 通过ID查找教室信息
     *
     * @param id ID
     * @return 教室信息
     */
    ClassRoomInfo findById(@Param("id") Long id, @Param("siteIdList") List<Long> siteIdList);

    /**
     * 保存教室信息
     *
     * @param record 教室信息
     * @return 保存数量
     */
    int insert(ClassRoomInfo record);

    /**
     * 通过name查找教室信息
     *
     * @param name 教室的名字
     * @return List<教室信息>
     */
    List<ClassRoomInfo> list(@Param("name") String name, @Param("siteIdList") List<Long> siteIdList);

    /**
     * 更新教室信息
     *
     * @param record 教室信息
     * @return 更新数量
     */
    int update(ClassRoomInfo record);

    /**
     * 更新教室信息
     *
     * @param record 教室信息
     * @return 更新数量
     */
    int updateProperty(ClassRoomInfo record);

}