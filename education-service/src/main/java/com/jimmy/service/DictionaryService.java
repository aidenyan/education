package com.jimmy.service;

import com.jimmy.dao.entity.Dictionary;
import com.jimmy.dao.entity.DictionaryItem;

import java.util.List;

public interface DictionaryService {
    /**
     * �����ֵ�����
     *
     * @param name �ֵ������
     */
    List<Dictionary> list(String name);

    /**
     * ��ѯ�ֵ����ϸ��Ϣ
     */
    List<DictionaryItem> list(Long dictionId);

    /**
     * ��ѯ�ֵ�����
     */
    Dictionary find(Long id);

    /**
     * ����
     */
    void save(Dictionary dictionary);

    /**
     * ����
     */
    void save(DictionaryItem dictionaryItem);

    /**
     * ɾ���ֵ�
     */
    void deletedDictionary(Long id);

    /**
     * ɾ���ֵ�����
     */
    void deletedDictionaryItem(Long id);
}
