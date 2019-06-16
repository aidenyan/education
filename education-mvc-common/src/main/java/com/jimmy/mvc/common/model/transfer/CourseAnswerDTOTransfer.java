package com.jimmy.mvc.common.model.transfer;

import com.jimmy.dao.entity.ClassRoomInfo;
import com.jimmy.dao.entity.CourseAnswer;
import com.jimmy.mvc.common.model.dto.ClassRoomDTO;
import com.jimmy.mvc.common.model.dto.CourseAnswerDTO;
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
public interface CourseAnswerDTOTransfer {

    CourseAnswerDTOTransfer INSTANCE = Mappers.getMapper(CourseAnswerDTOTransfer.class);

    @Mappings({@Mapping(target = "studentResult", expression = "java(courseAnswerDTO.getStudentResult()==null?null:com.alibaba.fastjson.JSON.toJSONString(courseAnswerDTO.getStudentResult()))"),
            @Mapping(target = "tearchResult", expression = "java(courseAnswerDTO.getTearchResult()==null?null:com.alibaba.fastjson.JSON.toJSONString(courseAnswerDTO.getTearchResult()))")
    })
    CourseAnswer toCourseAnswer(CourseAnswerDTO courseAnswerDTO);

    List<CourseAnswer> toCourseAnswerList(List<CourseAnswerDTO> courseAnswerDTOList);

    @Mappings({@Mapping(target = "studentResult", expression = "java(courseAnswer.getStudentResult()==null?null:com.alibaba.fastjson.JSON.parseArray(courseAnswer.getStudentResult(),com.jimmy.mvc.common.model.dto.AnswerDTO.class))"),
            @Mapping(target = "tearchResult", expression = "java(courseAnswerDTO.getTearchResult()==null?null:com.alibaba.fastjson.JSON.parseArray(courseAnswer.getTearchResult(),com.jimmy.mvc.common.model.dto.AnswerDTO.class))")
    })
    CourseAnswerDTO toCourseAnswerDTO(CourseAnswer courseAnswer);

    List<ClassRoomDTO> toClassRoomDTOList(List<ClassRoomInfo> classRoomList);
}
