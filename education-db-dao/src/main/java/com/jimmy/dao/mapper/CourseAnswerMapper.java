package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.CourseAnswer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseAnswerMapper {
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
     */
    CourseAnswer findByCourseStudent(@Param("courseId") Long courseId, @Param("machineId") Long machineId, @Param("coursewareItemId") Long coursewareItemId, @Param("siteIdList") List<Long> siteIdList);

    /**
     * 获取学生的回答信息
     */
    List<CourseAnswer> listByCourseStudentId(@Param("courseId") Long courseId, @Param("machineId") Long machineId, @Param("siteIdList") List<Long> siteIdList);
}