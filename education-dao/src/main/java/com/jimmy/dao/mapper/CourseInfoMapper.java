package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.CourseInfo;

public interface CourseInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CourseInfo record);

    int insertSelective(CourseInfo record);

    CourseInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CourseInfo record);

    int updateByPrimaryKeyWithBLOBs(CourseInfo record);

    int updateByPrimaryKey(CourseInfo record);
}