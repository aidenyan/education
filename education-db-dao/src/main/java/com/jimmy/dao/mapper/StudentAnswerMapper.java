package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.CourseAnswer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentAnswerMapper {
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
     *
     * @param courseStudentId
     * @return
     */
    List<CourseAnswer> listByCourseStudentId(@Param("courseStudentId") Long courseStudentId, @Param("siteIdList") List<Long> siteIdList);
}