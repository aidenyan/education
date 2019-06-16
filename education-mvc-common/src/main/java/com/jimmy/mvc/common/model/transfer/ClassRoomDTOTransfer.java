package com.jimmy.mvc.common.model.transfer;

import com.jimmy.dao.entity.ClassRoomInfo;
import com.jimmy.mvc.common.model.dto.ClassRoomDTO;
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
public interface ClassRoomDTOTransfer {

    ClassRoomDTOTransfer INSTANCE = Mappers.getMapper(ClassRoomDTOTransfer.class);


    ClassRoomInfo toClassRoom(ClassRoomDTO classRoomDTO);

    List<ClassRoomInfo> toClassRoomList(List<ClassRoomDTO> classRoomDTOList);


    ClassRoomDTO toClassRoomDTO(ClassRoomInfo classRoom);

    List<ClassRoomDTO> toClassRoomDTOList(List<ClassRoomInfo> classRoomList);
}
