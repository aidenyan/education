package com.jimmy.mvc.common.service.impl;

import com.jimmy.core.base.Page;
import com.jimmy.core.consts.PageConst;
import com.jimmy.dao.entity.CourseInfo;
import com.jimmy.dao.entity.StudentInfo;
import com.jimmy.dao.entity.TemporaryClassMate;
import com.jimmy.dao.entity.TemporaryStudentClassMate;
import com.jimmy.mvc.common.model.dto.StudentDetailDTO;
import com.jimmy.mvc.common.model.transfer.StudentInfoDTOTransfer;
import com.jimmy.mvc.common.service.CommonService;
import com.jimmy.service.CourseInfoService;
import com.jimmy.service.StudentInfoService;
import com.jimmy.service.TemporaryClassMateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private StudentInfoService studentInfoService;

    @Autowired
    private CourseInfoService courseInfoService;

    @Autowired
    private TemporaryClassMateService temporaryClassMateService;

    @Override
    public List<StudentDetailDTO> list(Long courseId) {
        CourseInfo courseInfo=courseInfoService.findById(courseId);
        TemporaryClassMate tempClass = temporaryClassMateService.findTempClassMate(courseId);
        if (tempClass == null) {
            return null;
        }
        List<TemporaryStudentClassMate> classMateList = temporaryClassMateService.list(tempClass.getId());
        if (CollectionUtils.isEmpty(classMateList)) {
            return null;
        }
        List<Long> studentIdList = new ArrayList<>();
        Map<Long, TemporaryStudentClassMate> studentIdMap = new HashMap<>();
        classMateList.forEach(classMate -> {
            studentIdList.add(classMate.getStudentId());
            studentIdMap.put(classMate.getStudentId(), classMate);
        });
        List<StudentInfo> studentInfoList = studentInfoService.list(studentIdList);
        List<StudentDetailDTO> studentDetailDTOList = new ArrayList<>();
        if (CollectionUtils.isEmpty(studentInfoList)) {
            return studentDetailDTOList;
        }
        studentInfoList.forEach(studentInfo -> {
            StudentDetailDTO studentDetailDTO = new StudentDetailDTO();
            TemporaryStudentClassMate temporaryStudentClassMate = studentIdMap.get(studentInfo.getId());
            studentDetailDTO.setIsAskLevel(temporaryStudentClassMate.getIsAskLevel());
            studentDetailDTO.setIsRegister(temporaryStudentClassMate.getIsRegister());
            studentDetailDTO.setMachineId(temporaryStudentClassMate.getMachineId());
            studentDetailDTO.setStudentInfoDTO(StudentInfoDTOTransfer.INSTANCE.toStudentInfoDTO(studentInfo));
            studentDetailDTO.setCourseId(courseId);
            studentDetailDTO.setCourseName(courseInfo.getName());
            studentDetailDTOList.add(studentDetailDTO);
        });
        return studentDetailDTOList;
    }

    @Override
    public Page<StudentDetailDTO> page(Long courseId, Long pageNo, Long pageSize) {
        if (pageNo == null) {
            pageNo = PageConst.PAGE_FIRST.longValue();
        }
        if (pageSize == null) {
            pageSize = PageConst.PAGE_DEFAULT_SIZE.longValue();
        }
        Page<StudentDetailDTO> page = new Page<>();

        TemporaryClassMate tempClass = temporaryClassMateService.findTempClassMate(courseId);
        if (tempClass == null) {
            page.setPageNo(PageConst.PAGE_FIRST);
            page.setPageSize(pageSize.intValue());
            page.setTotal(0);
            return page;
        }
        Long count = temporaryClassMateService.count(tempClass.getId());
        if (count < (pageNo - 1) * pageSize) {
            pageNo = count % pageSize == 0 ? count / pageSize : (count - count % pageSize) / pageSize + 1;
        }
        page.setPageNo(pageNo.intValue());
        page.setPageSize(pageSize.intValue());
        page.setTotal(count);
        if (count == 0) {
            return page;
        }
        List<TemporaryStudentClassMate> classMateList = temporaryClassMateService.listBySize(tempClass.getId(), (pageNo - 1) * pageSize, pageSize);
        if (CollectionUtils.isEmpty(classMateList)) {

            return page;
        }
        List<Long> studentIdList = new ArrayList<>();
        Map<Long, TemporaryStudentClassMate> studentIdMap = new HashMap<>();
        classMateList.forEach(classMate -> {
            studentIdList.add(classMate.getStudentId());
            studentIdMap.put(classMate.getStudentId(), classMate);
        });
        List<StudentInfo> studentInfoList = studentInfoService.listBase(studentIdList);
        List<StudentDetailDTO> studentDetailDTOList = new ArrayList<>();
        if (CollectionUtils.isEmpty(studentInfoList)) {

            return page;
        }
        CourseInfo courseInfo=courseInfoService.findById(courseId);
        studentInfoList.forEach(studentInfo -> {
            StudentDetailDTO studentDetailDTO = new StudentDetailDTO();
            TemporaryStudentClassMate temporaryStudentClassMate = studentIdMap.get(studentInfo.getId());
            studentDetailDTO.setIsAskLevel(temporaryStudentClassMate.getIsAskLevel());
            studentDetailDTO.setIsRegister(temporaryStudentClassMate.getIsRegister());
            studentDetailDTO.setMachineId(temporaryStudentClassMate.getMachineId());
            studentDetailDTO.setStudentInfoDTO(StudentInfoDTOTransfer.INSTANCE.toStudentInfoDTO(studentInfo));
            studentDetailDTO.setCourseId(courseId);
            studentDetailDTO.setCourseName(courseInfo.getName());
            studentDetailDTOList.add(studentDetailDTO);
        });
        page.setResult(studentDetailDTOList);
        return page;
    }
}
