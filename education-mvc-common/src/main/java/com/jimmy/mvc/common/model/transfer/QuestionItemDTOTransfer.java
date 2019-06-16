package com.jimmy.mvc.common.model.transfer;

import com.jimmy.dao.entity.QuestionItem;
import com.jimmy.mvc.common.model.dto.QuestionItemDTO;
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
public interface QuestionItemDTOTransfer {

    QuestionItemDTOTransfer INSTANCE = Mappers.getMapper(QuestionItemDTOTransfer.class);


    QuestionItem toQuestionItem(QuestionItemDTO questionItemDTO);

    List<QuestionItem> toQuestionItemList(List<QuestionItemDTO> questionItemDTOList);


    QuestionItemDTO toQuestionItemDTO(QuestionItem questionItem);

    List<QuestionItemDTO> toQuestionItemDTOList(List<QuestionItem> questionItemList);
}
