package com.jimmy.mvc.common.model.transfer;

import com.jimmy.model.vo.CoursewareDetailVO;
import com.jimmy.mvc.common.model.dto.CoursewareDetailDTO;
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
public interface CoursewareDetailDTOTransfer {

    CoursewareDetailDTOTransfer INSTANCE = Mappers.getMapper(CoursewareDetailDTOTransfer.class);


    CoursewareDetailVO toCoursewareDetailVO(CoursewareDetailDTO coursewareDetailDTO);

    List<CoursewareDetailVO> CoursewareDetailVOList(List<CoursewareDetailDTO> coursewareDetailDTOList);


    CoursewareDetailDTO toCoursewareDetailDTO(CoursewareDetailVO coursewareDetailVO);

    List<CoursewareDetailDTO> toCoursewareDetailDTOList(List<CoursewareDetailVO> coursewareDetailVOList);
}
