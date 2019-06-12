package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.CourseStudentRegister;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseStudentRegisterMapper {

    /**
     * ����ǩ����Ϣ
     *
     * @param record
     * @return
     */
    int insert(CourseStudentRegister record);

    /**
     * ��ȡǩ����Ϣ
     */
    List<CourseStudentRegister> listByCommand(@Param("commandId") Long commandId, @Param("siteIdList") List<Long> siteIdList);


}