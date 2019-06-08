package com.jimmy.service;

import com.jimmy.dao.entity.StudentInfo;

import java.util.List;

public interface StudentInfoService {
    /**
     * 根据的ID查找学生信息
     *
     * @param id ID
     * @return 学生信息
     */
    StudentInfo findById(Long id);

    /**
     * 根据登录账号查找学生信息
     *
     * @param name 学生登录账号
     * @return 学生信息
     */
    StudentInfo findByName(String name);

    /**
     * 根据名字搜索
     *
     * @param name 学生名字
     * @return List<学生信息>
     */
    List<StudentInfo> list(String name);

    /**
     * 更新token
     *
     * @param token token
     * @param id    ID
     */
    void updateToken(String token, Long id);


    /**
     * 保存学生信息
     *
     * @param studentInfo 学生信息
     * @return 保存的数量
     */
    int save(StudentInfo studentInfo);

}
