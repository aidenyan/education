package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.TemporaryStudentClassMate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TemporaryStudentClassMateMapper {
    /**
     * 保存班级临时学生信息
     *
     * @param record 班级临时学生关系表
     * @return 保存数量
     */
    int insert(TemporaryStudentClassMate record);

    /**
     * 删除临时关系表的学生信息
     *
     * @param tempClassMateId 临时班级
     * @return 删除结果
     */
    int deleted(@Param("tempClassMateId") Long tempClassMateId, @Param("siteIdList") List<Long> siteIdList);

    /**
     * 根据临时表查找学生信息
     *
     * @param tempClassMateId
     * @param siteIdList
     * @return
     */
    List<TemporaryStudentClassMate> list(@Param("tempClassMateId") Long tempClassMateId, @Param("siteIdList") List<Long> siteIdList);

    /**
     * 根据临时表查找学生信息
     *
     * @param tempClassMateId
     * @param siteIdList
     * @return
     */
    List<TemporaryStudentClassMate> listBySize(@Param("tempClassMateId") Long tempClassMateId, @Param("startNum") Long startNum, @Param("limitNum") Long limitNum, @Param("siteIdList") List<Long> siteIdList);

    /**
     * 根据临时表查找学生信息总数
     */
    Long count(@Param("tempClassMateId") Long tempClassMateId, @Param("siteIdList") List<Long> siteIdList);

    /**
     * 查找对应的班级的ID
     *
     * @param tempClassMateId
     * @param siteIdList
     * @return
     */

    List<Long> listClassMateId(@Param("tempClassMateId") Long tempClassMateId, @Param("siteIdList") List<Long> siteIdList);


    /**
     * 保存班级临时学生信息
     *
     * @param record 班级临时学生关系表
     * @return 保存数量
     */
    int updateByCourseStatus(TemporaryStudentClassMate record);
}