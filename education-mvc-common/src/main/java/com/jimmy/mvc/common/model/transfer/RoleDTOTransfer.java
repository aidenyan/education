package com.jimmy.mvc.common.model.transfer;

import com.jimmy.dao.entity.RoleInfo;
import com.jimmy.mvc.common.model.dto.RoleDTO;
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
public interface RoleDTOTransfer {

    RoleDTOTransfer INSTANCE = Mappers.getMapper(RoleDTOTransfer.class);


    RoleInfo toRoleInfo(RoleDTO roleDTO);

    List<RoleInfo> toRoleInfoList(List<RoleDTO> roleDTOList);


    RoleDTO toRoleDTO(RoleInfo roleInfo);

    List<RoleDTO> toRoleDTOList(List<RoleInfo> roleInfoList);


}
