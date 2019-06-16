package com.jimmy.mvc.common.model.transfer;

import com.jimmy.dao.entity.TeacherStaffInfo;
import com.jimmy.mvc.common.model.dto.TeacherStaffInfoDTO;
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
public interface TeacherStaffInfoDTOTransfer {

    TeacherStaffInfoDTOTransfer INSTANCE = Mappers.getMapper(TeacherStaffInfoDTOTransfer.class);

    @Mappings({@Mapping(target = "sex", expression = "java(teacherStaffInfoDTO.getSex()==null?null:teacherStaffInfoDTO.getSex().getValue())"),
            @Mapping(target = "staffType", expression = "java(teacherStaffInfoDTO.getStaffType()==null?null:teacherStaffInfoDTO.getStaffType().getValue())"),
           })
    TeacherStaffInfo toTeacherStaffInfo(TeacherStaffInfoDTO teacherStaffInfoDTO);

    List<TeacherStaffInfo> toTeacherStaffInfoList(List<TeacherStaffInfoDTO> teacherStaffInfoDTOList);

    @Mappings({
            @Mapping(target = "sex", expression = "java(teacherStaffInfo.getSex()==null?null:com.jimmy.mvc.common.model.enums.SexEnum.valueOf(teacherStaffInfo.getSex()))"),
            @Mapping(target = "staffType", expression = "java(teacherStaffInfo.getStaffType()==null?null:com.jimmy.mvc.common.model.enums.StaffTypeEnum.valueOf(teacherStaffInfo.getStaffType()))")})
    TeacherStaffInfoDTO toTeacherStaffInfoDTO(TeacherStaffInfo teacherStaffInfo);

    List<TeacherStaffInfoDTO> toTeacherStaffInfoDTOList(List<TeacherStaffInfo> teacherStaffInfo);
}
