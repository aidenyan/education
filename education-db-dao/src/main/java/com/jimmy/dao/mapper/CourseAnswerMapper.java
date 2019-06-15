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
     *
     */
    List<CourseAnswer> listMachineAnswer(@Param("courseId") Long courseId, @Param("machineId") Long machineId,
                                             @Param("itemIdList")  List<Long> itemIdList,
                                             @Param("siteIdList") List<Long> siteIdList);
}