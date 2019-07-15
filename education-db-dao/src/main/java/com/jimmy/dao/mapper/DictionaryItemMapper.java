package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.DictionaryItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DictionaryItemMapper {

    /**
     * �����ֵ�������Ϣ
     */
    int insert(DictionaryItem record);

    /**
     * ɾ��
     */
    int deletedById(@Param("idList") List<Long> idList, @Param("siteIdList") List<Long> siteIdList);

    /**
     * �����ֵ���Ϣ��ѯ
     *
     * @param dictionaryId
     * @return
     */
    List<DictionaryItem> listByDictionaryId(@Param("dictionaryId") Long dictionaryId, @Param("siteIdList") List<Long> siteIdList);

    /**
     * �����ֵ���ϸ��Ϣ
     */
    int updateProperty(DictionaryItem record);


}