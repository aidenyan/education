package com.jimmy.mvc.common.model.transfer;

import com.jimmy.dao.entity.Courseware;
import com.jimmy.mvc.common.model.dto.CoursewareDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @ClassName: ProtectionTransfer
 * @Description: ������vo��poת����
 * @author: wuyao
 * @date: 2019��5��15�� ����1:51:07
 */
@Mapper()
public interface CoursewareDTOTransfer {

    CoursewareDTOTransfer INSTANCE = Mappers.getMapper(CoursewareDTOTransfer.class);

    @Mappings({@Mapping(target = "levelNum", expression = "java(coursewareDTO.getLevelNum()==null?null:coursewareDTO.getLevelNum().getValue())")
    })
    Courseware toCourseware(CoursewareDTO coursewareDTO);

    List<Courseware> toCoursewareList(List<CoursewareDTO> coursewareDTOList);

    @Mappings({
            @Mapping(target = "levelNum", expression = "java(courseware.getLevelNum()==null?null:com.jimmy.mvc.common.model.enums.LevelTypeEnum.valueOf(courseware.getLevelNum()))"),
    })
    CoursewareDTO toCoursewareDTO(Courseware courseware);

    List<CoursewareDTO> toCoursewareDTOList(List<Courseware> coursewareList);
}
