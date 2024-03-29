package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.TeacherRoleKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherRoleMapper {
    /**
     * 根据教师ID查找角色ID
     *
     * @param staffId 教师ID
     * @return List<角色ID>
     */
    List<Long> list(@Param("staffId") Long staffId);

    /**
     * 删除角色关系
     *
     * @param staffId 教师ID
     */
    void deleted(@Param("staffId") Long staffId);

    /**
     * 保存角色和教师的关系信息
     *
     * @param teacherRoleKey 关系信息内容
     * @return 保存结果
     */
    int insert(TeacherRoleKey teacherRoleKey);
}