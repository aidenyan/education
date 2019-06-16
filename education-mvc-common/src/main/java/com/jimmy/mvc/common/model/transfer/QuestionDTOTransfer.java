package com.jimmy.mvc.common.model.transfer;

import com.jimmy.dao.entity.Question;
import com.jimmy.mvc.common.model.dto.QuestionDTO;
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
public interface QuestionDTOTransfer {

    QuestionDTOTransfer INSTANCE = Mappers.getMapper(QuestionDTOTransfer.class);


    @Mappings({@Mapping(target = "type", expression = "java(questionDTO.getType()==null?null:questionDTO.getType().getValue())"),
    })
    Question toQuestion(QuestionDTO questionDTO);

    List<Question> toQuestionList(List<QuestionDTO> questionDTOList);

    @Mappings({
            @Mapping(target = "type", expression = "java(question.getType()==null?null:com.jimmy.mvc.common.model.enums.QuestionTypeEnum.valueOf(question.getType()))")})
    QuestionDTO toQuestionDTO(Question question);

    List<QuestionDTO> toQuestionDTOList(List<Question> questionList);
}
