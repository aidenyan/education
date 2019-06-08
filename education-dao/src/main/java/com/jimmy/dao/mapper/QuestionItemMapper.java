package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.QuestionItem;

public interface QuestionItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(QuestionItem record);

    int insertSelective(QuestionItem record);

    QuestionItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QuestionItem record);

    int updateByPrimaryKey(QuestionItem record);
}