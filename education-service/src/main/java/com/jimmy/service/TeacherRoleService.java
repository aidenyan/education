package com.jimmy.service;

import com.jimmy.dao.entity.TeacherRoleKey;

import java.util.List;

public interface TeacherRoleService {
    /**
     * 根据教师ID查找角色ID
     *
     * @param staffId 教师ID
     * @return List<角色ID>
     */
    List<Long> list(Long staffId);

    /**
     * 删除角色关系
     *
     * @param teacherId 教师ID
     */
    void deleted(Long teacherId);

    /**
     * 保存角色和教师的关系信息
     *
     * @param teacherRoleKey 关系信息内容
     * @return 保存结果
     */
    int insert(TeacherRoleKey teacherRoleKey);
}
