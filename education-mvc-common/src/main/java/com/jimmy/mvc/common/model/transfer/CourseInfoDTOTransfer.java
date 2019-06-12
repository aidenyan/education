package com.jimmy.mvc.common.model.transfer;

import com.jimmy.dao.entity.CourseInfo;
import com.jimmy.mvc.common.model.dto.CourseInfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
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


    @Mappings({@Mapping(target = "usedStatus", expression = "java(courseInfoDTO.getUsedStatus()==null?null:courseInfoDTO.getUsedStatus().getValue())")
    })
    CourseInfo toCourseInfo(CourseInfoDTO courseInfoDTO);

    List<CourseInfo> toCourseInfoList(List<CourseInfoDTO> courseInfoDTOList);

    @Mappings({
            @Mapping(target = "usedStatus", expression = "java(courseInfo.getUsedStatus()==null?null:com.jimmy.mvc.common.model.enums.UsedStatusEnum.valueOf(courseInfo.getUsedStatus()))"),
    })
    CourseInfoDTO toCourseInfoDTO(CourseInfo courseInfo);

    List<CourseInfoDTO> toCourseInfoDTOList(List<CourseInfo> courseInfoList);
}
