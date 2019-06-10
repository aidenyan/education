package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.Courseware;

public interface CoursewareMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Courseware record);

    int insertSelective(Courseware record);

    Courseware selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Courseware record);

    int updateByPrimaryKeyWithBLOBs(Courseware record);

    int updateByPrimaryKey(Courseware record);
}