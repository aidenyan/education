package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.StudentStarInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface StudentStarInfoMapper {
    /**
     * 指定保存本周之星信息
     *
     * @param record 本周之星信息
     * @return 保存数量
     */
    int insert(StudentStarInfo record);

    /**
     * 删除本周之心
     *
     * @param id
     * @return
     */
    int deleted(@Param("id") Long id, @Param("siteIdList") List<Long> siteIdList);

    List<StudentStarInfo> list(@Param("startDate") Date startDate,@Param("endDate") Date endDate, @Param("siteIdList") List<Long> siteIdList);

}