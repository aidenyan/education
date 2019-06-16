package com.jimmy.mvc.common.model.transfer;

import com.jimmy.dao.entity.CoursewareItem;
import com.jimmy.mvc.common.model.dto.CoursewareItemDTO;
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
public interface CoursewareItemDTOTransfer {

    CoursewareItemDTOTransfer INSTANCE = Mappers.getMapper(CoursewareItemDTOTransfer.class);


    @Mappings({@Mapping(target = "type", expression = "java(coursewareItemDTO.getType()==null?null:coursewareItemDTO.getType().getValue())"),
            @Mapping(target = "contentType", expression = "java(coursewareItemDTO.getContentType()==null?null:coursewareItemDTO.getContentType().getValue())"),
    })
    CoursewareItem toCoursewareItem(CoursewareItemDTO coursewareItemDTO);

    List<CoursewareItem> toCoursewareItemList(List<CoursewareItemDTO> coursewareItemDTOList);

    @Mappings({
            @Mapping(target = "type", expression = "java(coursewareItem.getType()==null?null:com.jimmy.mvc.common.model.enums.CoursewareItemTypeEnum.valueOf(coursewareItem.getType()))"),
            @Mapping(target = "contentType", expression = "java(coursewareItem.getContentType()==null?null:com.jimmy.mvc.common.model.enums.ContentTypeEnum.valueOf(coursewareItem.getContentType()))")})
    CoursewareItemDTO toCoursewareItemDTO(CoursewareItem coursewareItem);

    List<CoursewareItemDTO> toCoursewareItemDTOList(List<CoursewareItem> coursewareItemList);
}
