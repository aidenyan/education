package com.jimmy.mvc.common.service.impl;

import com.jimmy.core.base.Page;
import com.jimmy.core.consts.PageConst;
import com.jimmy.dao.entity.*;
import com.jimmy.mvc.common.model.dto.StudentDetailDTO;
import com.jimmy.mvc.common.model.dto.StudentInfoStarDTO;
import com.jimmy.mvc.common.model.transfer.CourseStudentProcessRestartDTOTransfer;
import com.jimmy.mvc.common.model.transfer.StudentInfoDTOTransfer;
import com.jimmy.mvc.common.model.transfer.StudentInfoStarDTOTransfer;
import com.jimmy.mvc.common.service.CommonService;
import com.jimmy.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private StudentInfoService studentInfoService;

    @Autowired
    private CourseInfoService courseInfoService;

    @Autowired
    private StudentStarInfoService studentStarInfoService;

    @Autowired
    private TemporaryClassMateService temporaryClassMateService;

    @Autowired
    private CourseStudentProcessService courseStudentProcessService;

    @Override
    public List<StudentDetailDTO> list(Long courseId) {
        CourseInfo courseInfo = courseInfoService.findById(courseId);
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
        List<CourseStudentProcess> courseStudentProcessList = courseStudentProcessService.list(courseId);
        Map<Long, CourseStudentProcess> processIdMap = new HashMap<>();
        if (!CollectionUtils.isEmpty(courseStudentProcessList)) {
            courseStudentProcessList.forEach(courseStudentProcess -> {
                processIdMap.put(courseStudentProcess.getStudentId(), courseStudentProcess);
            });
        }
        studentInfoList.forEach(studentInfo -> {
            StudentDetailDTO studentDetailDTO = new StudentDetailDTO();
            TemporaryStudentClassMate temporaryStudentClassMate = studentIdMap.get(studentInfo.getId());
            studentDetailDTO.setIsAskLevel(temporaryStudentClassMate.getIsAskLevel());
            studentDetailDTO.setIsRegister(temporaryStudentClassMate.getIsRegister());
            studentDetailDTO.setMachineId(temporaryStudentClassMate.getMachineId());
            studentDetailDTO.setStudentInfoDTO(StudentInfoDTOTransfer.INSTANCE.toStudentInfoDTO(studentInfo));
            studentDetailDTO.setCourseId(courseId);
            studentDetailDTO.setRegisterCommandId(temporaryStudentClassMate.getRegisterCommandId());
            studentDetailDTO.setCourseName(courseInfo.getName());
            studentDetailDTO.setProcess(CourseStudentProcessRestartDTOTransfer.INSTANCE.toCourseStudentProcessRestartDTO(processIdMap.get(studentInfo.getId())));
            studentDetailDTOList.add(studentDetailDTO);
        });
        return studentDetailDTOList;
    }

    @Override
    public List<StudentDetailDTO> list(Long courseId, Long machineId) {
        CourseInfo courseInfo = courseInfoService.findById(courseId);
        TemporaryClassMate tempClass = temporaryClassMateService.findTempClassMate(courseId);
        if (tempClass == null) {
            return null;
        }
        List<TemporaryStudentClassMate> classMateList = temporaryClassMateService.listByMachine(tempClass.getId(), machineId);
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
        List<CourseStudentProcess> courseStudentProcessList = courseStudentProcessService.listByMachine(courseId, machineId);
        Map<Long, CourseStudentProcess> processIdMap = new HashMap<>();
        if (!CollectionUtils.isEmpty(courseStudentProcessList)) {
            courseStudentProcessList.forEach(courseStudentProcess -> {
                processIdMap.put(courseStudentProcess.getStudentId(), courseStudentProcess);
            });
        }
        studentInfoList.forEach(studentInfo -> {
            StudentDetailDTO studentDetailDTO = new StudentDetailDTO();
            TemporaryStudentClassMate temporaryStudentClassMate = studentIdMap.get(studentInfo.getId());
            studentDetailDTO.setIsAskLevel(temporaryStudentClassMate.getIsAskLevel());
            studentDetailDTO.setIsRegister(temporaryStudentClassMate.getIsRegister());
            studentDetailDTO.setMachineId(temporaryStudentClassMate.getMachineId());
            studentDetailDTO.setStudentInfoDTO(StudentInfoDTOTransfer.INSTANCE.toStudentInfoDTO(studentInfo));
            studentDetailDTO.setCourseId(courseId);
            studentDetailDTO.setRegisterCommandId(temporaryStudentClassMate.getRegisterCommandId());
            studentDetailDTO.setCourseName(courseInfo.getName());
            studentDetailDTO.setProcess(CourseStudentProcessRestartDTOTransfer.INSTANCE.toCourseStudentProcessRestartDTO(processIdMap.get(studentInfo.getId())));
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
        CourseInfo courseInfo = courseInfoService.findById(courseId);
        studentInfoList.forEach(studentInfo -> {
            StudentDetailDTO studentDetailDTO = new StudentDetailDTO();
            TemporaryStudentClassMate temporaryStudentClassMate = studentIdMap.get(studentInfo.getId());
            studentDetailDTO.setRegisterCommandId(temporaryStudentClassMate.getRegisterCommandId());
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

    @Override
    public List<StudentInfoStarDTO> listStar() {
        Map<Long, String> starMap = studentStarInfoService.mapStar();
        List<Long> studentIdList = starMap.keySet().stream().collect(Collectors.toList());
        if (CollectionUtils.isEmpty(studentIdList)) {
            return Collections.EMPTY_LIST;
        }
        List<StudentInfo> studentInfoList = studentInfoService.list(studentIdList);
        if (CollectionUtils.isEmpty(studentInfoList)) {
            return Collections.EMPTY_LIST;
        }
        List<StudentInfoStarDTO> studentInfoStarDTOList = StudentInfoStarDTOTransfer.INSTANCE.toStudentInfoStarDTOList(studentInfoList);
        studentInfoStarDTOList.forEach(studentInfoStarDTO -> studentInfoStarDTO.setStarName(starMap.get(studentInfoStarDTO.getId())));
        return studentInfoStarDTOList;
    }
}
