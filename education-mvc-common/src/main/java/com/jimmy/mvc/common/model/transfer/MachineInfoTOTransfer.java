package com.jimmy.mvc.common.model.transfer;

import com.jimmy.dao.entity.MachineInfo;
import com.jimmy.mvc.common.model.dto.ClassRoomDTO;
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
public interface MachineInfoTOTransfer {

    MachineInfoTOTransfer INSTANCE = Mappers.getMapper(MachineInfoTOTransfer.class);


    MachineInfo toClassRoom(ClassRoomDTO classRoomDTO);

    List<MachineInfo> toClassRoomList(List<ClassRoomDTO> classRoomDTOList);


    ClassRoomDTO toClassRoomDTO(MachineInfo classRoom);

    List<ClassRoomDTO> toClassRoomDTOList(List<MachineInfo> classRoomList);
}
