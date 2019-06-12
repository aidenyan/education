package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.CourseAnswer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseAnswerMapper {
    /**
     * ����
     *
     * @param record
     * @return
     */
    int insert(CourseAnswer record);

    /**
     * ����
     *
     * @param record
     * @return
     */
    int updateProperty(CourseAnswer record);

    /**
     * ��ȡѧ���Ļش���Ϣ
     */
    CourseAnswer findByCourseStudent(@Param("courseId") Long courseId, @Param("machineId") Long machineId, @Param("coursewareItemId") Long coursewareItemId, @Param("siteIdList") List<Long> siteIdList);

    /**
     * ��ȡѧ���Ļش���Ϣ
     */
    List<CourseAnswer> listByCourseStudentId(@Param("courseId") Long courseId, @Param("machineId") Long machineId, @Param("siteIdList") List<Long> siteIdList);
}