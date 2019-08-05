package com.jimmy.mvc.common.model.transfer;

import com.jimmy.dao.entity.CourseStudentProcess;
import com.jimmy.mvc.common.model.dto.CourseStudentProcessDTO;
import com.jimmy.mvc.common.model.dto.CourseStudentProcessRestartDTO;
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
public interface CourseStudentProcessRestartDTOTransfer {

    CourseStudentProcessRestartDTOTransfer INSTANCE = Mappers.getMapper(CourseStudentProcessRestartDTOTransfer.class);


    CourseStudentProcess toCourseStudentProcess(CourseStudentProcessRestartDTO courseStudentProcessRestartDTO);

    List<CourseStudentProcess> toCourseStudentProcessList(List<CourseStudentProcessRestartDTO> courseStudentProcessRestartDTOList);


    CourseStudentProcessRestartDTO toCourseStudentProcessRestartDTO(CourseStudentProcess courseStudentProcess);

    List<CourseStudentProcessRestartDTO> toCourseStudentProcessRestartDTOList(List<CourseStudentProcess> courseStudentProcessList);
}
