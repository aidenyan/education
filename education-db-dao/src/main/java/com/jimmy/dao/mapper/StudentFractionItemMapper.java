package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.StudentFractionItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentFractionItemMapper {
    /**
     * ���������Ϣ
     *
     * @param record ������Ϣ��Ϣ
     * @return ��������
     */
    int insert(StudentFractionItem record);

    /**
     * ���ݷ������Ҹ����������
     *
     * @param fractionId
     * @return
     */
    List<StudentFractionItem> list(@Param("fractionId") Long fractionId);


}