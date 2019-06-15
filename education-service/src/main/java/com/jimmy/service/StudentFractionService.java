package com.jimmy.service;

import com.jimmy.dao.entity.StudentFraction;
import com.jimmy.dao.entity.StudentTotalFaction;
import com.jimmy.model.vo.StudentFractionVo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: StudentFractionService
 * @Description:
 * @author: aiden
 * @date: 2019/6/12/012.
 */
public interface StudentFractionService {

    /**
     * 根据开始时间和结束时间获取大于这个分数的信息
     *
     * @param fraction  分数
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return List<学生信息>
     */
    List<StudentTotalFaction> listByFraction(BigDecimal fraction, Date startDate, Date endDate);

    /**
     * 获取学生的分数
     */
    List<StudentFraction> list(Long courseId, List<Long> studentIdList);

    /**
     * 保存
     *
     * @param studentFractionVos
     */
    void save(List<StudentFractionVo> studentFractionVos);
}
