package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.Courseware;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CoursewareMapper {


    int insert(Courseware record);

    List<Courseware> list(@Param("courseId") Long courseId, @Param("siteIdList") List<Long> siteIdList);


    int updateProperty(Courseware record);

    int count(@Param("courseId") Long courseId, @Param("siteIdList") List<Long> siteIdList);

    Courseware find(@Param("coursewareId") Long coursewareId, @Param("siteIdList") List<Long> siteIdList);


    List<Courseware> listByCourseName(@Param("coursewareName")String coursewareName, @Param("siteIdList") List<Long> siteIdList);
}