package com.jimmy.service.impl;

import com.jimmy.common.utils.DateUtils;
import com.jimmy.dao.entity.StudentFraction;
import com.jimmy.dao.entity.StudentInfo;
import com.jimmy.dao.entity.StudentStarInfo;
import com.jimmy.dao.local.model.dto.SysInfoDTO;
import com.jimmy.dao.local.thread.SiteLocalThread;
import com.jimmy.dao.local.thread.SysInfoLocalThread;
import com.jimmy.dao.mapper.StudentStarInfoMapper;
import com.jimmy.service.StudentFractionService;
import com.jimmy.service.StudentInfoService;
import com.jimmy.service.StudentStarInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: StudentStarInfoServiceImpl
 * @Description:
 * @author: aiden
 * @date: 2019/6/12/012.
 */
@Service
@Transactional(readOnly = true)
public class StudentStarInfoServiceImpl implements StudentStarInfoService {
    @Autowired
    private StudentInfoService studentInfoService;

    @Autowired
    private StudentStarInfoMapper studentStarInfoMapper;

    @Autowired
    private StudentFractionService studentFractionService;


    @Override
    public List<StudentInfo> listStar() {
        Date theWeekStart = DateUtils.getWeekStart();
        Date theWeekEnd = DateUtils.getWeekEnd();
        List<StudentStarInfo> studentStarInfoList = studentStarInfoMapper.list(theWeekStart, theWeekEnd, SiteLocalThread.getSiteIdList());
        List<Long> studentIdList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(studentStarInfoList)) {
            studentStarInfoList.forEach(studentStarInfo -> {
                studentIdList.add(studentStarInfo.getStudentId());
            });
        }
        SysInfoDTO sysInfoDTO = SysInfoLocalThread.get();
        List<StudentFraction> studentFractionList = studentFractionService.listByFraction(sysInfoDTO.getFraction(), theWeekStart, theWeekEnd);
        if (!CollectionUtils.isEmpty(studentFractionList)) {
            studentFractionList.forEach(studentFraction -> {
                studentIdList.add(studentFraction.getStudentId());
            });
        }
        if (CollectionUtils.isEmpty(studentIdList)) {
            return Collections.EMPTY_LIST;
        }
        return studentInfoService.list(studentIdList);
    }

    @Override
    public void setStar(Long teacherId, Long studentId) {

    }
}
