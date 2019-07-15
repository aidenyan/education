package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.DictionaryItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DictionaryItemMapper {

    /**
     * 保存字典内容信息
     */
    int insert(DictionaryItem record);

    /**
     * 删除
     */
    int deletedById(@Param("idList") List<Long> idList, @Param("siteIdList") List<Long> siteIdList);

    /**
     * 根据字典信息查询
     *
     * @param dictionaryId
     * @return
     */
    List<DictionaryItem> listByDictionaryId(@Param("dictionaryId") Long dictionaryId, @Param("siteIdList") List<Long> siteIdList);

    /**
     * 更新字典详细信息
     */
    int updateProperty(DictionaryItem record);


}