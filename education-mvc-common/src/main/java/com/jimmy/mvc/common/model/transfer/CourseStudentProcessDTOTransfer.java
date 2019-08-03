package com.jimmy.mvc.common.model.transfer;

import com.jimmy.dao.entity.ClassRoomInfo;
import com.jimmy.dao.entity.CourseStudentProcess;
import com.jimmy.mvc.common.model.dto.ClassRoomDTO;
import com.jimmy.mvc.common.model.dto.CourseStudentProcessDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @ClassName: ProtectionTransfer
 * @Description: ������vo��poת����
 * @author: wuyao
 * @date: 2019��5��15�� ����1:51:07
 */
@Mapper()
public interface CourseStudentProcessDTOTransfer {

    CourseStudentProcessDTOTransfer INSTANCE = Mappers.getMapper(CourseStudentProcessDTOTransfer.class);


    CourseStudentProcess toCourseStudentProcess(CourseStudentProcessDTO courseStudentProcessDTO);

    List<CourseStudentProcess> toCourseStudentProcessList(List<CourseStudentProcessDTO> courseStudentProcessDTOList);


    CourseStudentProcessDTO toCourseStudentProcessDTO(CourseStudentProcess courseStudentProcess);

    List<CourseStudentProcessDTO> toCourseStudentProcessDTOList(List<CourseStudentProcess> courseStudentProcessList);
}
