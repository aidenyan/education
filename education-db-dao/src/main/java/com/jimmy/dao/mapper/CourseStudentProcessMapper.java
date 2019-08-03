package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.CourseStudentProcess;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseStudentProcessMapper {

    int insert(CourseStudentProcess record);


    CourseStudentProcess findProcess(@Param("machineId") Long machineId, @Param("courseId") Long courseId, @Param("coursewareId") Long coursewareId,@Param("studentId") Long studentId , @Param("siteIdList") List<Long> siteIdList);

    int updateProperty(CourseStudentProcess record);

    List<CourseStudentProcess> list(@Param("courseId") Long courseId, @Param("siteIdList") List<Long> siteIdList);

    int endProcess(@Param("machineId") Long machineId, @Param("courseId") Long courseId, @Param("siteId") Long siteId);
}