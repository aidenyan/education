package com.jimmy.service;

import com.jimmy.dao.entity.Dictionary;
import com.jimmy.dao.entity.DictionaryItem;

import java.util.List;

public interface DictionaryService {
    /**
     * 查找字典内容
     *
     * @param name 字典的名字
     */
    List<Dictionary> list(String name);

    /**
     * 查询字典的详细信息
     */
    List<DictionaryItem> list(Long dictionId);

    /**
     * 查询字典内容
     */
    Dictionary find(Long id);

    /**
     * 保存
     */
    void save(Dictionary dictionary);

    /**
     * 保存
     */
    void save(DictionaryItem dictionaryItem);

    /**
     * 删除字典
     */
    void deletedDictionary(Long id);

    /**
     * 删除字典内容
     */
    void deletedDictionaryItem(Long id);
}
