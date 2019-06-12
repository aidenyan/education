package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.CourseAnswer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentAnswerMapper {
    /**
     * 保存
     *
     * @param record
     * @return
     */
    int insert(CourseAnswer record);

    /**
     * 更新
     *
     * @param record
     * @return
     */
    int updateProperty(CourseAnswer record);

    /**
     * 获取学生的回答信息
     *
     * @param courseStudentId
     * @return
     */
    List<CourseAnswer> listByCourseStudentId(@Param("courseStudentId") Long courseStudentId, @Param("siteIdList") List<Long> siteIdList);
}