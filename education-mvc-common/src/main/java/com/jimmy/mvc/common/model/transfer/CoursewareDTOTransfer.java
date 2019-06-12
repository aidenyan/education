package com.jimmy.mvc.common.model.transfer;

import com.jimmy.dao.entity.Courseware;
import com.jimmy.mvc.common.model.dto.CoursewareDTO;
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
public interface CoursewareDTOTransfer {

    CoursewareDTOTransfer INSTANCE = Mappers.getMapper(CoursewareDTOTransfer.class);


    Courseware toCourseware(CoursewareDTO coursewareDTO);

    List<Courseware> toCoursewareList(List<CoursewareDTO> coursewareDTOList);


    CoursewareDTO toCoursewareDTO(Courseware courseware);

    List<CoursewareDTO> toCoursewareDTOList(List<Courseware> coursewareList);
}
