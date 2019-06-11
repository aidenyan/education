package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.StudentFractionItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentFractionItemMapper {
    /**
     * 保存分数信息
     *
     * @param record 分数信息信息
     * @return 保存数量
     */
    int insert(StudentFractionItem record);

    /**
     * 根据分数查找各项分数总数
     *
     * @param fractionId
     * @return
     */
    List<StudentFractionItem> list(@Param("fractionId") Long fractionId);


}