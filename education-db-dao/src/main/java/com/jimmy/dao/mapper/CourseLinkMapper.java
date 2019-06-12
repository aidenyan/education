package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.CourseLinkKey;
import org.apache.ibatis.annotations.Param;

public interface CourseLinkMapper {
    /**
     * 根据课程删除课程和课件关联
     *
     * @param courseId 课程
     * @return 删除数量
     */
    int deleteByCourseId(@Param("courseId") Long courseId);

    /**
     * 根据课件删除课程和课件关联
     *
     * @param coursewareId 课件
     * @return 删除数量
     */
    int deleteByCoursewareId(@Param("coursewareId") Long coursewareId);

    /**
     * 保存关联关系
     *
     * @param record 关联
     * @return 保存结果
     */
    int insert(CourseLinkKey record);


}