package com.jimmy.mvc.common.service.impl;

import com.jimmy.core.base.Page;
import com.jimmy.dao.entity.StudentInfo;
import com.jimmy.dao.entity.TemporaryClassMate;
import com.jimmy.dao.entity.TemporaryStudentClassMate;
import com.jimmy.mvc.common.model.dto.StudentDetailDTO;
import com.jimmy.mvc.common.model.transfer.StudentInfoDTOTransfer;
import com.jimmy.mvc.common.service.CommonService;
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
    private TemporaryClassMateService temporaryClassMateService;

    @Override
    public List<StudentDetailDTO> list(Long courseId) {
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
            studentDetailDTOList.add(studentDetailDTO);
        });
        return studentDetailDTOList;
    }

    @Override
    public Page<StudentDetailDTO> page(Long courseId) {
        return null;
    }
}
