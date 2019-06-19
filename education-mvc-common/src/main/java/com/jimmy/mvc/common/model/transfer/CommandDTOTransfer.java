package com.jimmy.mvc.common.model.transfer;

import com.jimmy.dao.entity.CommandInfo;
import com.jimmy.mvc.common.model.dto.CommandDTO;
import com.jimmy.mvc.common.model.dto.CommandDetailDTO;
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


    @Mappings({@Mapping(target = "commandType", expression = "java(courseInfoDTO.getCommandType()==null?null:courseInfoDTO.getCommandType().getValue())"),
            @Mapping(target = "direction", expression = "java(courseInfoDTO.getDirection()==null?null:courseInfoDTO.getDirection().getValue())")
    })
    CommandInfo toCommandInfo(CommandDTO courseInfoDTO);

    List<CommandInfo> toCommandInfoList(List<CommandDTO> courseInfoDTOList);

    @Mappings({
            @Mapping(target = "commandType", expression = "java(commandInfo.getCommandType()==null?null:com.jimmy.mvc.common.model.enums.CommandTypeEnum.valueOf(commandInfo.getCommandType()))"),
            @Mapping(target = "direction", expression = "java(commandInfo.getDirection()==null?null:com.jimmy.mvc.common.model.enums.DirectionEnum.valueOf(commandInfo.getDirection()))")
    })
    CommandDTO toCommandDTO(CommandInfo commandInfo);

    List<CommandDTO> toCommandDTOList(List<CommandInfo> commandInfoList);

    @Mappings({@Mapping(target = "content", expression = "java(commandDetailDTO.getDetail()==null?null:com.alibaba.fastjson.JSON.toJSONString(commandDetailDTO.getDetail()))")
    })
    CommandDTO toCommandDTO(CommandDetailDTO commandDetailDTO);
}
