package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.CourseStudentRegister;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseStudentRegisterMapper {

    /**
     * 保存签到信息
     *
     * @param record
     * @return
     */
    int insert(CourseStudentRegister record);

    /**
     * 获取签到信息
     */
    List<CourseStudentRegister> listByCommand(@Param("commandId") Long commandId, @Param("siteIdList") List<Long> siteIdList);


}