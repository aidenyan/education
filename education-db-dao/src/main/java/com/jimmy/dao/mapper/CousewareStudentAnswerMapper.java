package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.CousewareStudentAnswer;
import com.jimmy.dao.entity.CousewareStudentAnswerWithBLOBs;

public interface CousewareStudentAnswerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CousewareStudentAnswerWithBLOBs record);

    int insertSelective(CousewareStudentAnswerWithBLOBs record);

    CousewareStudentAnswerWithBLOBs selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CousewareStudentAnswerWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(CousewareStudentAnswerWithBLOBs record);

    int updateByPrimaryKey(CousewareStudentAnswer record);
}