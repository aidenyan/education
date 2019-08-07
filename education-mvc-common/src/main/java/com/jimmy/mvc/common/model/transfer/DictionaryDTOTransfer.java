package com.jimmy.mvc.common.model.transfer;

import com.jimmy.dao.entity.ClassRoomInfo;
import com.jimmy.dao.entity.Dictionary;
import com.jimmy.mvc.common.model.dto.ClassRoomDTO;
import com.jimmy.mvc.common.model.dto.DictionaryDTO;
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
public interface DictionaryDTOTransfer {

    DictionaryDTOTransfer INSTANCE = Mappers.getMapper(DictionaryDTOTransfer.class);


    Dictionary toDictionary(DictionaryDTO dictionaryDTO);

    List<Dictionary> toDictionaryList(List<DictionaryDTO> dictionaryDTOList);


    DictionaryDTO toDictionaryDTO(Dictionary dictionary);

    List<DictionaryDTO> toDictionaryDTOList(List<Dictionary> dictionaryList);
}
