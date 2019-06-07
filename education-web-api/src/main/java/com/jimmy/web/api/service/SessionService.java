package com.jimmy.web.api.service;

import com.jimmy.dao.entity.MenuInfo;
import com.jimmy.dao.entity.TeacherStaffInfo;

import java.util.List;

public interface SessionService {
    /**
     * 通过session获取教师的登录信息
     *
     * @return 教师的登录信息
     */
    TeacherStaffInfo find();

    /**
     * 在session中保存老师信息
     *
     * @param teacherStaffInfo 老师信息
     */
    void save(TeacherStaffInfo teacherStaffInfo);

    /**
     * 保存用户的权限菜单
     *
     * @param menuInfoList 菜单列表
     */
    void save(List<MenuInfo> menuInfoList);

    /**
     * 菜单信息
     *
     * @return List<菜单信息>
     */
    List<MenuInfo> listMenuInfo();
}
