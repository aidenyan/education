package com.jimmy.service;

import com.jimmy.dao.entity.QuestionItem;

import java.util.List;

public interface QuestionItemService {
    /**
     * 根据ID查找问题
     *
     * @param questionId ID
     * @return 问题信息
     */
    List<QuestionItem> list(Long questionId);
    /**
     * 根据ID查找问题
     *
     * @param questionIdList ID
     * @return 问题信息
     */
    List<QuestionItem> list(List<Long> questionIdList);
    /**
     * 保存选项
     *
     * @param itemList 选择项列表
     */
    void save(List<QuestionItem> itemList,Long questionId);

    /**
     * 根据questionId删除选项
     *
     * @param questionId 问题ID
     */
    void deleted(Long questionId);
}
