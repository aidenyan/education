package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.CourseLinkKey;
import org.apache.ibatis.annotations.Param;

public interface CourseLinkMapper {
    /**
     * ���ݿγ�ɾ���γ̺Ϳμ�����
     *
     * @param courseId �γ�
     * @return ɾ������
     */
    int deleteByCourseId(@Param("courseId") Long courseId);

    /**
     * ���ݿμ�ɾ���γ̺Ϳμ�����
     *
     * @param coursewareId �μ�
     * @return ɾ������
     */
    int deleteByCoursewareId(@Param("coursewareId") Long coursewareId);

    /**
     * ���������ϵ
     *
     * @param record ����
     * @return ������
     */
    int insert(CourseLinkKey record);


}