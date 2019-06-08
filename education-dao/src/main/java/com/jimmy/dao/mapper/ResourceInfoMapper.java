package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.ResourceInfo;

public interface ResourceInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ResourceInfo record);

    int insertSelective(ResourceInfo record);

    ResourceInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ResourceInfo record);

    int updateByPrimaryKeyWithBLOBs(ResourceInfo record);

    int updateByPrimaryKey(ResourceInfo record);
}