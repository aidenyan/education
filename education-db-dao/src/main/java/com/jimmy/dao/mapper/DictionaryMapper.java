package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.Dictionary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DictionaryMapper {

    /**
     * 保存
     */
    int insert(Dictionary record);

    /**
     * 查找
     */
    List<Dictionary> list(@Param("name") String name, @Param("siteIdList") List<Long> siteIdList);


    /**
     * 详情
     */
    Dictionary find(@Param("id") Long id, @Param("siteIdList") List<Long> siteIdList);

    /**
     * 更新
     */
    int updateProperty(Dictionary record);

}