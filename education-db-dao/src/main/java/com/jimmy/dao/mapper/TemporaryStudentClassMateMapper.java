package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.TemporaryStudentClassMate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TemporaryStudentClassMateMapper {
    /**
     * ����༶��ʱѧ����Ϣ
     *
     * @param record �༶��ʱѧ����ϵ��
     * @return ��������
     */
    int insert(TemporaryStudentClassMate record);

    /**
     * ɾ����ʱ��ϵ����ѧ����Ϣ
     *
     * @param tempClassMateId ��ʱ�༶
     * @return ɾ�����
     */
    int deleted(@Param("tempClassMateId") Long tempClassMateId, @Param("siteIdList") List<Long> siteIdList);

    /**
     * ������ʱ������ѧ����Ϣ
     *
     * @param tempClassMateId
     * @param siteIdList
     * @return
     */
    List<TemporaryStudentClassMate> list(@Param("tempClassMateId") Long tempClassMateId, @Param("siteIdList") List<Long> siteIdList);


}