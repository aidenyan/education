package com.jimmy.service.impl;

import com.jimmy.common.utils.DateUtils;
import com.jimmy.core.local.thread.LoginLocalThread;
import com.jimmy.dao.entity.StudentStarInfo;
import com.jimmy.dao.entity.StudentTotalFaction;
import com.jimmy.dao.local.model.dto.SysInfoDTO;
import com.jimmy.dao.local.thread.SiteLocalThread;
import com.jimmy.dao.local.thread.SysInfoLocalThread;
import com.jimmy.dao.mapper.StudentStarInfoMapper;
import com.jimmy.service.StudentFractionService;
import com.jimmy.service.StudentStarInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private StudentStarInfoMapper studentStarInfoMapper;

    @Autowired
    private StudentFractionService studentFractionService;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void setStar(Long teacherId, Long studentId, String starName) {
        deleteStar(studentId);
        StudentStarInfo studentStarInfo = new StudentStarInfo();
        studentStarInfo.setName(starName);
        studentStarInfo.setStudentId(studentId);
        studentStarInfo.setTearcherId(teacherId);
        studentStarInfo.setModifyId(LoginLocalThread.get());
        studentStarInfo.setCreateId(LoginLocalThread.get());
        studentStarInfo.setSiteId(SiteLocalThread.getSiteId());
        studentStarInfoMapper.insert(studentStarInfo);
    }
    @Transactional(rollbackFor = Exception.class)
    public void deleteStar(Long studentId) {
        Date theWeekStart = DateUtils.getWeekStart();
        Date theWeekEnd = DateUtils.getWeekEnd();
        List<StudentStarInfo> studentStarInfoList = studentStarInfoMapper.list(theWeekStart, theWeekEnd, SiteLocalThread.getSiteIdList());
        Map<Long, StudentStarInfo> studentIdMap = new HashMap<>();
        if (!CollectionUtils.isEmpty(studentStarInfoList)) {
            studentStarInfoList.forEach(studentStarInfo -> {
                studentIdMap.put(studentStarInfo.getStudentId(), studentStarInfo);
            });
        }
        StudentStarInfo studentStarInfo = studentIdMap.get(studentId);
        if (studentStarInfo != null) {
            studentStarInfoMapper.deleted(studentStarInfo.getStudentId(), SiteLocalThread.getSiteIdList());
        }

    }

    @Override
    public Map<Long, String> mapStar() {
        Date theWeekStart = DateUtils.getWeekStart();
        Date theWeekEnd = DateUtils.getWeekEnd();
        List<StudentStarInfo> studentStarInfoList = studentStarInfoMapper.list(theWeekStart, theWeekEnd, SiteLocalThread.getSiteIdList());
        Map<Long, String> studentIdMap = new HashMap<>();
        if (!CollectionUtils.isEmpty(studentStarInfoList)) {
            studentStarInfoList.forEach(studentStarInfo -> {
                studentIdMap.put(studentStarInfo.getStudentId(), studentStarInfo.getName());
            });
        }
        SysInfoDTO sysInfoDTO = SysInfoLocalThread.get();
        if (sysInfoDTO != null) {
            List<StudentTotalFaction> studentFractionList = studentFractionService.listByFraction(sysInfoDTO.getFraction(), theWeekStart, theWeekEnd);
            if (!CollectionUtils.isEmpty(studentFractionList)) {
                studentFractionList.forEach(studentFraction -> {
                    if (studentIdMap.get(studentFraction.getStudentId()) == null) {
                        studentIdMap.put(studentFraction.getStudentId(), "Ñ§Ï°Ö®ÐÇ");
                    }
                });
            }
        }
        return studentIdMap;
    }
}
