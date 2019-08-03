package com.jimmy.service;

import java.util.Map;

/**
 * @ClassName: StudentStarInfoService
 * @Description:
 * @author: aiden
 * @date: 2019/6/12/012.
 */
public interface StudentStarInfoService {


    /**
     * 保存为本周之星
     *
     * @param teacherId 老师ID
     * @param studentId 学生ID
     */
    void setStar(Long teacherId, Long studentId, String starName);

    /**
     * 获取学习之星的名字
     *
     * @return
     */
    Map<Long, String> mapStar();

    /**
     * 删除本周之星
     *
     * @param studentId
     */
    void deleteStar(Long studentId);
}
