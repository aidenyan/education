package com.jimmy.mvc.common.model.transfer;

import com.jimmy.dao.entity.StudentInfo;
import com.jimmy.mvc.common.model.dto.StudentInfoDTO;
import com.jimmy.mvc.common.model.dto.StudentInfoStarDTO;
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
public interface StudentInfoStarDTOTransfer {


    StudentInfoStarDTOTransfer INSTANCE = Mappers.getMapper(StudentInfoStarDTOTransfer.class);

    @Mappings({
            @Mapping(target = "sex", expression = "java(studentInfo.getSex()==null?null:com.jimmy.mvc.common.model.enums.SexEnum.valueOf(studentInfo.getSex()))"),
    })
    StudentInfoStarDTO toStudentInfoStarDTO(StudentInfo studentInfo);

    List<StudentInfoStarDTO> toStudentInfoStarDTOList(List<StudentInfo> studentInfoList);
}
