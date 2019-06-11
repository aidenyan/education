package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.StudentFraction;
import org.apache.ibatis.annotations.Param;

public interface StudentFractionMapper {


    int insert(StudentFraction record);

    StudentFraction find(@Param("id") Long id);


}