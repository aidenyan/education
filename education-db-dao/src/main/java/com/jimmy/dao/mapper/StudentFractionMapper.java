package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.StudentFraction;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface StudentFractionMapper {


    int insert(StudentFraction record);

    StudentFraction find(@Param("id") Long id, @Param("siteIdList") List<Long> siteIdList);

    List<StudentFraction> listByFraction(@Param("fraction") BigDecimal fraction, @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("siteIdList") List<Long> siteIdList);
}