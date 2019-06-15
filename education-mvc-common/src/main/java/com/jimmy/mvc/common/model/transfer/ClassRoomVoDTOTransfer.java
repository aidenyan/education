package com.jimmy.mvc.common.model.transfer;

import com.jimmy.model.vo.ClassRoomVO;
import com.jimmy.mvc.common.model.dto.ClassRoomVoDTO;
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
public interface ClassRoomVoDTOTransfer {

    ClassRoomVoDTOTransfer INSTANCE = Mappers.getMapper(ClassRoomVoDTOTransfer.class);


    ClassRoomVO toClassRoomVO(ClassRoomVoDTO classRoomVoDTO);

    List<ClassRoomVO> toClassRoomVOList(List<ClassRoomVoDTO> classRoomDTOList);


    ClassRoomVoDTO toClassRoomVoDTO(ClassRoomVO classRoom);

    List<ClassRoomVoDTO> toClassRoomVoDTOList(List<ClassRoomVO> classRoomList);
}
