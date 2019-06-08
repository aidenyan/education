package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.QuestionItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionItemMapper {


    /**
     * 保存问题
     *
     * @param record 问题
     * @return 保存结果选择项
     */
    int insert(QuestionItem record);

    /**
     * 根据ID查找问题
     *
     * @param questionId         ID
     * @param siteIdList
     * @return 问题信息
     */
    List<QuestionItem> list(@Param("questionId") Long questionId, @Param("siteIdList") List<Long> siteIdList);

    /**
     * 根据问题ID删除选择项
     *
     * @param questionId 问题
     * @return 删除数量
     */

    int deleted(@Param("questionId") Long questionId, @Param("siteIdList") List<Long> siteIdList);


}