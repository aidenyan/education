package com.jimmy.mvc.common.model.transfer;

import com.jimmy.dao.entity.CourseInfo;
import com.jimmy.mvc.common.model.dto.CourseInfoDTO;
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
public interface CourseInfoDTOTransfer {

    CourseInfoDTOTransfer INSTANCE = Mappers.getMapper(CourseInfoDTOTransfer.class);


    CourseInfo toCourseInfo(CourseInfoDTO courseInfoDTO);

    List<CourseInfo> toCourseInfoList(List<CourseInfoDTO> courseInfoDTOList);


    CourseInfoDTO toCourseInfoDTO(CourseInfo courseInfo);

    List<CourseInfoDTO> toCourseInfoDTOList(List<CourseInfo> courseInfoList);
}
