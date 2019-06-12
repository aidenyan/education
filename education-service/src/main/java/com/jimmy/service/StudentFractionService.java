package com.jimmy.service;

import com.jimmy.dao.entity.StudentFraction;

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
    List<StudentFraction> listByFraction(BigDecimal fraction, Date startDate, Date endDate);
}
