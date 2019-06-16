package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.StudentFraction;
import com.jimmy.dao.entity.StudentTotalFaction;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface StudentFractionMapper {


    int insert(StudentFraction record);

    StudentFraction find(@Param("id") Long id, @Param("siteIdList") List<Long> siteIdList);

    List<StudentTotalFaction> listByFraction(@Param("fraction") BigDecimal fraction, @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("siteIdList") List<Long> siteIdList);

    List<StudentFraction> listByCourseId(@Param("courseId") Long courseId,  @Param("studentIdList") List<Long> studentIdList, @Param("siteIdList") List<Long> siteIdList);

}