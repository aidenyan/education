package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.TemporaryClassMate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TemporaryClassMateMapper {
    /**
     * ������Ϣ
     *
     * @param record ��Ϣ
     * @return
     */
    int insert(TemporaryClassMate record);

    /**
     * ���ݿγ�ID��ȡ��ʱ�༶
     *
     * @param courseId �γ�ID
     * @return ��ʱ�༶
     */
    TemporaryClassMate find(@Param("courseId") Long courseId, @Param("siteIdList") List<Long> siteIdList);

    /**
     * ����IDɾ����ʱ�༶
     * @param id ID
     */
    void deleted(@Param("id") Long id, @Param("siteIdList") List<Long> siteIdList);

}