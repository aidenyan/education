package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.ClassRoomInfo;

public interface ClassRoomInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ClassRoomInfo record);

    int insertSelective(ClassRoomInfo record);

    ClassRoomInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ClassRoomInfo record);

    int updateByPrimaryKeyWithBLOBs(ClassRoomInfo record);

    int updateByPrimaryKey(ClassRoomInfo record);
}