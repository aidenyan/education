package com.jimmy.mvc.common.model.transfer;

import com.jimmy.dao.entity.DictionaryItem;
import com.jimmy.mvc.common.model.dto.DictionaryItemDTO;
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
public interface DictionaryItemDTOTransfer {

    DictionaryItemDTOTransfer INSTANCE = Mappers.getMapper(DictionaryItemDTOTransfer.class);


    DictionaryItem toDictionaryItem(DictionaryItemDTO dictionaryItemDTO);

    List<DictionaryItem> toDictionaryItemList(List<DictionaryItemDTO> dictionaryItemDTOList);


    DictionaryItemDTO toDictionaryItemDTO(DictionaryItem dictionaryItem);

    List<DictionaryItemDTO> toDictionaryItemDTOList(List<DictionaryItem> dictionaryItemList);
}
