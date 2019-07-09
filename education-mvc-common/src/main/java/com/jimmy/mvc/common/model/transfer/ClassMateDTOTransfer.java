package com.jimmy.mvc.common.model.transfer;

import com.jimmy.dao.entity.ClassMate;
import com.jimmy.dao.entity.RoleInfo;
import com.jimmy.mvc.common.model.dto.ClassMateDTO;
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
public interface ClassMateDTOTransfer {

    ClassMateDTOTransfer INSTANCE = Mappers.getMapper(ClassMateDTOTransfer.class);


    ClassMate toClassMate(ClassMateDTO classMateDTO);

    List<ClassMate> toClassMateList(List<ClassMateDTO> classMateDTOList);


    ClassMateDTO toClassMateDTO(ClassMate classMate);

    List<ClassMateDTO> toClassMateDTOList(List<ClassMate> classMateList);


}
