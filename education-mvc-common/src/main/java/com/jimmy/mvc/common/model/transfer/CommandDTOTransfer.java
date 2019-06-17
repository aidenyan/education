package com.jimmy.mvc.common.model.transfer;

import com.jimmy.dao.entity.CommandInfo;
import com.jimmy.mvc.common.model.dto.CommandDTO;
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
public interface CommandDTOTransfer {

    CommandDTOTransfer INSTANCE = Mappers.getMapper(CommandDTOTransfer.class);


    @Mappings({@Mapping(target = "commandType", expression = "java(courseInfoDTO.getCommandType()==null?null:courseInfoDTO.getCommandType().getValue())")
    })
    CommandInfo toCommandInfo(CommandDTO courseInfoDTO);

    List<CommandInfo> toCommandInfoList(List<CommandDTO> courseInfoDTOList);

    @Mappings({
            @Mapping(target = "commandType", expression = "java(commandInfo.getCommandType()==null?null:com.jimmy.mvc.common.model.enums.CommadTypeEnum.valueOf(commandInfo.getCommandType()))"),
    })
    CommandDTO toCommandDTO(CommandInfo commandInfo);

    List<CommandDTO> toCommandDTOList(List<CommandInfo> commandInfoList);
}
