package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.CourseStudent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseStudentMapper {

    /**
     * ����
     *
     * @param record
     * @return
     */
    int insert(CourseStudent record);

    /**
     * ����
     *
     * @param record
     * @return
     */
    int updateProperty(CourseStudent record);

    /**
     * ���ݿγ�ID��ȡѧ������Ϣ
     *
     * @param courseId
     * @param siteIdList
     * @return
     */

    List<CourseStudent> listByCourseId(@Param("courseId") Long courseId, @Param("status") Integer status, @Param("siteIdList") List<Long> siteIdList);


    /**
     * ѧ�������γ�
     */
    int updateCourseStudentStatus(@Param("courseId") Long courseId, @Param("studentId") Long studentId, @Param("status") Integer status, @Param("siteId") Long siteId);

    /**
     * ɾ��
     *
     * @param courseId
     * @param studentId
     * @param siteId
     */
    int deleted(@Param("courseId") Long courseId, @Param("studentId") Long studentId, @Param("siteId") Long siteId);

    /**
     * ɾ��
     *
     * @param courseId
     * @param studentId
     * @param siteId
     */
    void update(@Param("courseId") Long courseId, @Param("studentId") Long studentId, @Param("siteId") Long siteId);
}