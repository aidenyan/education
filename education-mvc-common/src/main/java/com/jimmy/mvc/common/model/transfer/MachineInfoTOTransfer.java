package com.jimmy.mvc.common.model.transfer;

import com.jimmy.dao.entity.MachineInfo;
import com.jimmy.mvc.common.model.dto.ClassRoomDTO;
import com.jimmy.mvc.common.model.dto.MachineInfoDTO;
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
public interface MachineInfoTOTransfer {

    MachineInfoTOTransfer INSTANCE = Mappers.getMapper(MachineInfoTOTransfer.class);


    MachineInfo toMachineInfo(MachineInfoDTO machineInfoDTO);

    List<MachineInfo> toMachineInfoList(List<MachineInfoDTO> machineInfoDTOList);


    MachineInfoDTO toMachineInfoDTO(MachineInfo machineInfo);

    List<MachineInfoDTO> toMachineInfoDTOList(List<MachineInfo> machineInfoList);
}
