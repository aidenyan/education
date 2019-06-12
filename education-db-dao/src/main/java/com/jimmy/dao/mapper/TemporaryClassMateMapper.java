package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.TemporaryClassMate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TemporaryClassMateMapper {
    /**
     * 保存信息
     *
     * @param record 信息
     * @return
     */
    int insert(TemporaryClassMate record);

    /**
     * 根据课程ID获取临时班级
     *
     * @param courseId 课程ID
     * @return 临时班级
     */
    TemporaryClassMate find(@Param("courseId") Long courseId, @Param("siteIdList") List<Long> siteIdList);

    /**
     * 根据ID删除临时班级
     * @param id ID
     */
    void deleted(@Param("id") Long id, @Param("siteIdList") List<Long> siteIdList);

}