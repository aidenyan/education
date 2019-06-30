package com.jimmy.mvc.common.model.transfer;

import com.jimmy.dao.entity.CommandInfo;
import com.jimmy.dao.entity.MenuInfo;
import com.jimmy.mvc.common.model.dto.CommandDTO;
import com.jimmy.mvc.common.model.dto.CommandDetailDTO;
import com.jimmy.mvc.common.model.dto.MenuDTO;
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
public interface MenuDTOTransfer {

    MenuDTOTransfer INSTANCE = Mappers.getMapper(MenuDTOTransfer.class);



    MenuInfo toMenuInfo(MenuDTO menuDTO);

    List<MenuInfo> toMenuInfoList(List<MenuDTO> menuDTOList);


    MenuDTO toMenuDTO(MenuInfo menuInfo);

    List<MenuDTO> toMenuDTOList(List<MenuInfo> menuInfoList);


}
