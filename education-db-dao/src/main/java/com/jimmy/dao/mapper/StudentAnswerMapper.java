package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.StudentAnswer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentAnswerMapper {
    /**
     * 保存
     *
     * @param record
     * @return
     */
    int insert(StudentAnswer record);

    /**
     * 更新
     *
     * @param record
     * @return
     */
    int updateProperty(StudentAnswer record);

    /**
     * 获取学生的回答信息
     *
     * @param courseStudentId
     * @return
     */
    List<StudentAnswer> listByCourseStudentId(@Param("courseStudentId") Long courseStudentId, @Param("siteIdList") List<Long> siteIdList);
}