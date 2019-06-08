package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.CoursewareItem;

public interface CoursewareItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CoursewareItem record);

    int insertSelective(CoursewareItem record);

    CoursewareItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CoursewareItem record);

    int updateByPrimaryKeyWithBLOBs(CoursewareItem record);

    int updateByPrimaryKey(CoursewareItem record);
}