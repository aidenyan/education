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
     * 更新需要更新的信息
     *
     * @param teacherStaffInfo
     */
    void updateProperty(TeacherStaffInfo teacherStaffInfo);

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
    void save(TeacherStaffInfo teacherStaffInfo, List<Long> roleIdList);

    /**
     * 根据ID更新token的值
     *
     * @param id    ID
     * @param token token
     */
    void updateAppToken(Long id, String token, Long roomId);

    /**
     * 根据ID更新token的值
     *
     * @param id    ID
     * @param token token
     */
    void updatePadAppToken(Long id, String token);


    /**
     * 保存老师头部特征
     */
    int updateHeader(String headerInfo, Long id);
    /**
     * 保存老师头部图片
     */
    int updateHeaderImg(String headerImg, Long id);
    /**
     * 删除教师
     *
     * @param id ID
     */
    void deleted(Long id);
}
