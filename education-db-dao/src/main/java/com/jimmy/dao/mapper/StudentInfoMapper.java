package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.StudentInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentInfoMapper {
    /**
     * 根据的ID查找学生信息
     *
     * @param id ID
     * @return 学生信息
     */
    StudentInfo findById(@Param("id") Long id, @Param("siteIdList") List<Long> siteIdList);

    /**
     * 根据登录账号查找学生信息
     *
     * @param name 学生登录账号
     * @return 学生信息
     */
    StudentInfo findByName(@Param("name") String name, @Param("siteIdList") List<Long> siteIdList);

    /**
     * 根据名字搜索
     *
     * @param name       学生名字
     * @param siteIdList 站点ID
     * @return List<学生信息>
     */
    List<StudentInfo> list(@Param("name") String name, @Param("siteIdList") List<Long> siteIdList);
    /**
     * 根据id获取学生信息
     * @param idList ID列表
     * @return List<学生信息>
     */
    List<StudentInfo> listByIdList(@Param("idList")List<Long> idList, @Param("siteIdList") List<Long> siteIdList);
    /**
     * 根据班级ID获取学生信息
     * @param classMateIdList 班级ID
     * @return List<学生信息>
     */
    List<StudentInfo> listByClassMate(@Param("classMateIdList") List<Long> classMateIdList,@Param("siteIdList") List<Long> siteIdList);
    /**
     * 保存学生信息
     *
     * @param studentInfo 学生信息
     * @return 保存的数量
     */
    int insert(StudentInfo studentInfo);

    /**
     * 更新学生信息
     *
     * @param studentInfo 学生信息
     * @return 更新的数量
     */
    int update(StudentInfo studentInfo);
    /**
     * 更新学生信息
     *
     * @param studentInfo 学生信息
     * @return 更新的数量
     */
    int updateProperty(StudentInfo studentInfo);

}