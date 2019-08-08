package com.jimmy.service;

import com.jimmy.dao.entity.Question;
import com.jimmy.dao.entity.QuestionItem;

import java.util.List;

public interface QuestionService {
    /**
     * 删除问题
     *
     * @param id ID
     */
    void deleted(Long id);

    /**
     * 保存问题
     *
     * @param record 问题
     * @return 保存结果
     */
    void save(Question record, List<QuestionItem> questionItemList);

    /**
     * 根据ID查找问题
     *
     * @param id ID
     * @return 问题信息
     */
    Question findById(Long id);

    /**
     * 根据ID查找问题
     *
     * @param question 问题的内容
     * @return 问题信息
     */
    List<Question> list(String question);


    Long count(String question);

}
