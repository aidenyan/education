package com.jimmy.service;

import com.jimmy.dao.entity.ResourceInfo;

import java.util.List;

public interface ResourceInfoService {
    /**
     * 保存
     *
     * @param record 资源信息
     * @return 更新数量
     */
    int save(ResourceInfo record);

    /**
     *
     * @param id
     */
    void deleted(Long id);
    /**
     * 根据ID查询资源信息
     *
     * @param id ID
     * @return 资源信息
     */
    ResourceInfo findById(Long id);


    /**
     * 根据type查询资源信息
     *
     * @param type ID
     * @return 资源信息
     */
    List<ResourceInfo> list(Integer type);

}
