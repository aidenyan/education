package com.jimmy.service;

import com.jimmy.dao.entity.TeacherStaffInfo;

import java.util.List;

public interface TeacherStaffInfoService {
    /**
     * 根据的ID查找老师信息
     *
     * @param id ID
     * @return 老师信息
     */
    TeacherStaffInfo findById(Long id);

    /**
     * 根据登录账号查找老师信息
     *
     * @param name 老师登录账号
     * @return 老师信息
     */
    TeacherStaffInfo findByName(String name);

    /**
     * 根据名字搜索
     *
     * @param name 老师名字
     * @return List<老师信息>
     */
    List<TeacherStaffInfo> list(String name);

    /**
     * 保存老师信息
     *
     * @param teacherStaffInfo 老师信息
     * @return 保存的数量
     */
    void save(TeacherStaffInfo teacherStaffInfo);

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
