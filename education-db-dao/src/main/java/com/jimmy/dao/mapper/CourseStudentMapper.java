package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.CourseStudent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseStudentMapper {

    /**
     * 保存
     *
     * @param record
     * @return
     */
    int insert(CourseStudent record);

    /**
     * 更新
     *
     * @param record
     * @return
     */
    int updateProperty(CourseStudent record);

    /**
     * 根据课程ID获取学生可信息
     *
     * @param courseId
     * @param siteIdList
     * @return
     */

    List<CourseStudent> listByCourseId(@Param("courseId") Long courseId, @Param("status") Integer status, @Param("machineId") Long machineId, @Param("siteIdList") List<Long> siteIdList);


    /**
     * 学生结束课程
     */
    int updateCourseStudentStatus(@Param("courseId") Long courseId, @Param("machineId") Long machineId, @Param("status") Integer status, @Param("siteId") Long siteId);

    /**
     * 删除
     *
     * @param courseId
     * @param studentId
     * @param siteId
     */
    int deleted(@Param("courseId") Long courseId, @Param("studentId") Long studentId, @Param("siteId") Long siteId);

    /**
     * 删除
     *
     * @param courseId
     * @param siteId
     */
    void update(@Param("courseId") Long courseId, @Param("studentId") Long studentId, @Param("siteId") Long siteId);

    /**
     * 查找机床等路的信息
     */
    List<CourseStudent> find(@Param("courseId") Long courseId, @Param("studentId") Long studentId, @Param("machineId") Long machineId, @Param("siteIdList") List<Long> siteIdList);

    /**
     * 查找机床等路的信息
     */
    CourseStudent findById(@Param("courseStudentId") Long courseStudentId, @Param("siteIdList") List<Long> siteIdList);

}