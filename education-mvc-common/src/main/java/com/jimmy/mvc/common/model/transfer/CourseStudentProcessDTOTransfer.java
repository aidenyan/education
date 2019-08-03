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
 * @Description: 属性名vo，po转换器
 * @author: wuyao
 * @date: 2019年5月15日 下午1:51:07
 */
@Mapper()
public interface CourseStudentProcessDTOTransfer {

    CourseStudentProcessDTOTransfer INSTANCE = Mappers.getMapper(CourseStudentProcessDTOTransfer.class);


    CourseStudentProcess toCourseStudentProcess(CourseStudentProcessDTO courseStudentProcessDTO);

    List<CourseStudentProcess> toCourseStudentProcessList(List<CourseStudentProcessDTO> courseStudentProcessDTOList);


    CourseStudentProcessDTO toCourseStudentProcessDTO(CourseStudentProcess courseStudentProcess);

    List<CourseStudentProcessDTO> toCourseStudentProcessDTOList(List<CourseStudentProcess> courseStudentProcessList);
}
