package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.TeacherStaffInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherStaffInfoMapper {
    /**
     * 根据的ID查找老师信息
     *
     * @param id ID
     * @return 老师信息
     */
    TeacherStaffInfo findById(@Param("id") Long id, @Param("siteIdList") List<Long> siteIdList);

    /**
     * 根据登录账号查找老师信息
     *
     * @param name 老师登录账号
     * @return 老师信息
     */
    TeacherStaffInfo findByName(@Param("name") String name, @Param("siteIdList") List<Long> siteIdList);

    /**
     * 根据名字搜索
     *
     * @param name       老师名字
     * @param siteIdList 站点ID
     * @return List<老师信息>
     */
    List<TeacherStaffInfo> list(@Param("name") String name, @Param("siteIdList") List<Long> siteIdList);

    /**
     * 保存老师信息
     *
     * @param teacherStaffInfo 老师信息
     * @return 保存的数量
     */
    int insert(TeacherStaffInfo teacherStaffInfo);

    /**
     * 更新老师信息
     *
     * @param teacherStaffInfo 老师信息
     * @return 更新的数量
     */
    int update(TeacherStaffInfo teacherStaffInfo);

    /**
     * 更新老师信息
     *
     * @param teacherStaffInfo 老师信息
     * @return 更新的数量
     */
    int updateProperty(TeacherStaffInfo teacherStaffInfo);
}