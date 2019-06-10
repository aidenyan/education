package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.CoursewareStudentAnswer;
import com.jimmy.dao.entity.CoursewareStudentAnswerWithBLOBs;

public interface CoursewareStudentAnswerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CoursewareStudentAnswerWithBLOBs record);

    int insertSelective(CoursewareStudentAnswerWithBLOBs record);

    CoursewareStudentAnswerWithBLOBs selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CoursewareStudentAnswerWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(CoursewareStudentAnswerWithBLOBs record);

    int updateByPrimaryKey(CoursewareStudentAnswer record);
}