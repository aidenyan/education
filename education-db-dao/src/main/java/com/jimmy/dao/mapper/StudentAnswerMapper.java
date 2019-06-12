package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.StudentAnswer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentAnswerMapper {
    /**
     * ����
     *
     * @param record
     * @return
     */
    int insert(StudentAnswer record);

    /**
     * ����
     *
     * @param record
     * @return
     */
    int updateProperty(StudentAnswer record);

    /**
     * ��ȡѧ���Ļش���Ϣ
     *
     * @param courseStudentId
     * @return
     */
    List<StudentAnswer> listByCourseStudentId(@Param("courseStudentId") Long courseStudentId, @Param("siteIdList") List<Long> siteIdList);
}