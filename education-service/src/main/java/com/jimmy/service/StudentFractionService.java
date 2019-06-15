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
     * ���ݿ�ʼʱ��ͽ���ʱ���ȡ���������������Ϣ
     *
     * @param fraction  ����
     * @param startDate ��ʼʱ��
     * @param endDate   ����ʱ��
     * @return List<ѧ����Ϣ>
     */
    List<StudentTotalFaction> listByFraction(BigDecimal fraction, Date startDate, Date endDate);

    /**
     * ��ȡѧ���ķ���
     */
    List<StudentFraction> list(Long courseId, List<Long> studentIdList);

    /**
     * ����
     *
     * @param studentFractionVos
     */
    void save(List<StudentFractionVo> studentFractionVos);
}
