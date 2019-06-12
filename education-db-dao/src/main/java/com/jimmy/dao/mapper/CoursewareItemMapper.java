package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.CoursewareItem;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

public interface CoursewareItemMapper {

    int insert(CoursewareItem record);

    List<CoursewareItem> listByCoursewareId(@Param("coursewareId") Long coursewareId, @Param("siteIdList") List<Long> siteIdList);

    List<CoursewareItem> listByCoursewareIdList(@Param("coursewareIdList") Collection<Long> coursewareIdList, @Param("siteIdList") List<Long> siteIdList);


    int deleted(@Param("coursewareId") Long coursewareId, @Param("siteIdList") List<Long> siteIdList);
}