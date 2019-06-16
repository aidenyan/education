package com.jimmy.mvc.common.model.transfer;

import com.jimmy.model.vo.ClassRoomVO;
import com.jimmy.mvc.common.model.dto.ClassRoomVoDTO;
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
public interface ClassRoomVoDTOTransfer {

    ClassRoomVoDTOTransfer INSTANCE = Mappers.getMapper(ClassRoomVoDTOTransfer.class);


    ClassRoomVO toClassRoomVO(ClassRoomVoDTO classRoomVoDTO);

    List<ClassRoomVO> toClassRoomVOList(List<ClassRoomVoDTO> classRoomDTOList);


    ClassRoomVoDTO toClassRoomVoDTO(ClassRoomVO classRoom);

    List<ClassRoomVoDTO> toClassRoomVoDTOList(List<ClassRoomVO> classRoomList);
}
