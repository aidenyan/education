package com.jimmy.service;

import com.jimmy.dao.entity.StudentInfo;

import java.util.List;

/**
 * @ClassName: StudentStarInfoService
 * @Description:
 * @author: aiden
 * @date: 2019/6/12/012.
 */
public interface StudentStarInfoService {
    /**
     * 获取本周的之星
     *
     * @return list<本周之星的学生信息>
     */
    List<StudentInfo> listStar();

    /**
     * 保存为本周之星
     *
     * @param teacherId 老师ID
     * @param studentId 学生ID
     */
    void setStar(Long teacherId, Long studentId);
}
