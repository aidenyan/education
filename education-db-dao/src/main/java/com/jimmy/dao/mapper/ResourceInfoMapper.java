package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.ResourceInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResourceInfoMapper {
    /**
     * 保存
     *
     * @param record 资源信息
     * @return 更新数量
     */
    int insert(ResourceInfo record);


    /**
     * 根据ID查询资源信息
     *
     * @param id ID
     * @return 资源信息
     */
    ResourceInfo findById(@Param("id") Long id, @Param("siteIdList") List<Long> siteIdList);


    /**
     * 根据name查询资源信息
     *
     * @param type type
     * @return 资源信息
     */
    List<ResourceInfo> list(@Param("type") Integer type, @Param("siteIdList") List<Long> siteIdList);

    /**
     * 更新
     *
     * @param record 资源信息
     * @return 更新数量
     */
    int update(ResourceInfo record);

    /**
     * 更新
     *
     * @param record 资源信息
     * @return 更新数量
     */
    int updateProperty(ResourceInfo record);

}