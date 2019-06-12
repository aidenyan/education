package com.jimmy.service.impl;

import com.jimmy.dao.entity.StudentFraction;
import com.jimmy.dao.local.thread.SiteLocalThread;
import com.jimmy.dao.mapper.StudentFractionMapper;
import com.jimmy.service.StudentFractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: StudentFractionServiceImpl
 * @Description:
 * @author: aiden
 * @date: 2019/6/12/012.
 */
@Service
@Transactional(readOnly = true)
public class StudentFractionServiceImpl implements StudentFractionService {

    @Autowired
    private StudentFractionMapper studentFractionMapper;

    @Override
    public List<StudentFraction> listByFraction(BigDecimal fraction, Date startDate, Date endDate) {
        Assert.notNull(fraction);
        Assert.notNull(startDate);
        Assert.notNull(endDate);
        return studentFractionMapper.listByFraction(fraction, startDate, endDate, SiteLocalThread.getSiteIdList());
    }
}
