package com.jimmy.mvc.common.model.transfer;

import com.jimmy.dao.entity.StudentInfo;
import com.jimmy.mvc.common.model.dto.StudentInfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @ClassName: ProtectionTransfer
 * @Description: 属性名vo，po转换器
 * @author: wuyao
 * @date: 2019年5月15日 下午1:51:07
 */
@Mapper()
public interface StudentInfoDTOTransfer {

    StudentInfoDTOTransfer INSTANCE = Mappers.getMapper(StudentInfoDTOTransfer.class);

    @Mappings({@Mapping(target = "sex", expression = "java(studentInfoDTO.getSex()==null?null:studentInfoDTO.getSex().getValue())"),
            @Mapping(target = "staffType", expression = "java(studentInfoDTO.getStaffType()==null?null:studentInfoDTO.getStaffType().getValue())"),
    })
    StudentInfo toStudentInfo(StudentInfoDTO studentInfoDTO);

    List<StudentInfo> toStudentInfoList(List<StudentInfoDTO> studentInfoDTOList);

    @Mappings({
            @Mapping(target = "sex", expression = "java(studentInfo.getSex()==null?null:com.jimmy.mvc.common.model.enums.SexEnum.valueOf(studentInfo.getSex()))"),
    })
    StudentInfoDTO toStudentInfoDTO(StudentInfo studentInfo);

    List<StudentInfoDTO> toStudentInfoDTOList(List<StudentInfo> studentInfoList);
}
