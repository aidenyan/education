package com.jimmy.mvc.common.model.transfer;

import com.jimmy.dao.entity.ResourceInfo;
import com.jimmy.dao.entity.StudentInfo;
import com.jimmy.mvc.common.model.dto.ResourceInfoDTO;
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
public interface ResourceInfoDTOTransfer {

    ResourceInfoDTOTransfer INSTANCE = Mappers.getMapper(ResourceInfoDTOTransfer.class);

    @Mappings({@Mapping(target = "type", expression = "java(resourceInfoDTO.getType()==null?null:resourceInfoDTO.getType().getValue())")
    })
    ResourceInfo toResourceInfo(ResourceInfoDTO resourceInfoDTO);

    List<ResourceInfo> toResourceInfoList(List<ResourceInfoDTO> resourceInfoDTOList);

    @Mappings({
            @Mapping(target = "type", expression = "java(resourceInfo.getType()==null?null:com.jimmy.mvc.common.model.enums.ResourceTypeEnum.valueOf(resourceInfo.getType()))"),
    })
    ResourceInfoDTO toResourceInfoDTO(ResourceInfo resourceInfo);

    List<ResourceInfoDTO> toResourceInfoDTOList(List<ResourceInfo> resourceInfoList);
}
