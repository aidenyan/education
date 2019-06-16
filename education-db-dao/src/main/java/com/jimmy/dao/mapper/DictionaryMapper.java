package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.Dictionary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DictionaryMapper {

    /**
     * ����
     */
    int insert(Dictionary record);

    /**
     * ����
     */
    List<Dictionary> list(@Param("name") String name, @Param("siteIdList") List<Long> siteIdList);


    /**
     * ����
     */
    Dictionary find(@Param("id") Long id, @Param("siteIdList") List<Long> siteIdList);

    /**
     * ����
     */
    int updateProperty(Dictionary record);

}