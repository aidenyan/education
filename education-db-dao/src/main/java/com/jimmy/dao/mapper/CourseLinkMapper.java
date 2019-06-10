package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.CourseLinkKey;

public interface CourseLinkMapper {
    int deleteByPrimaryKey(CourseLinkKey key);

    int insert(CourseLinkKey record);

    int insertSelective(CourseLinkKey record);
}