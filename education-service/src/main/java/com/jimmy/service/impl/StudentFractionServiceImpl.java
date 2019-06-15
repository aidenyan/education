package com.jimmy.service.impl;

import com.jimmy.dao.entity.StudentFraction;
import com.jimmy.dao.entity.StudentFractionItem;
import com.jimmy.dao.entity.StudentTotalFaction;
import com.jimmy.dao.local.thread.SiteLocalThread;
import com.jimmy.dao.mapper.StudentFractionItemMapper;
import com.jimmy.dao.mapper.StudentFractionMapper;
import com.jimmy.model.vo.StudentFractionVo;
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

    @Autowired
    private StudentFractionItemMapper studentFractionItemMapper;

    @Override
    public List<StudentTotalFaction> listByFraction(BigDecimal fraction, Date startDate, Date endDate) {
        Assert.notNull(fraction);
        Assert.notNull(startDate);
        Assert.notNull(endDate);
        return studentFractionMapper.listByFraction(fraction, startDate, endDate, SiteLocalThread.getSiteIdList());
    }

    @Override
    public List<StudentFraction> list(Long courseId, List<Long> studentIdList) {
        Assert.notNull(courseId);
        Assert.notEmpty(studentIdList);
        return studentFractionMapper.listByCourseId(courseId, studentIdList, SiteLocalThread.getSiteIdList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(List<StudentFractionVo> studentFractionVos) {
        Assert.notEmpty(studentFractionVos);
        studentFractionVos.forEach(studentFractionVo -> {
            StudentFraction studentFraction = studentFractionVo.getStudentFraction();
            Assert.isNull(studentFraction.getId());
            studentFractionMapper.insert(studentFraction);
            List<StudentFractionItem> itemList = studentFractionVo.getStudentFractionItemList();
            Assert.notEmpty(itemList);
            itemList.forEach(studentFractionItem -> {
                studentFractionItem.setFractionId(studentFraction.getId());
                Assert.isNull(studentFractionItem.getId());
                studentFractionItemMapper.insert(studentFractionItem);
            });
        });

    }
}
