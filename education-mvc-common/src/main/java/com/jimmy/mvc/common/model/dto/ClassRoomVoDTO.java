package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Api("教室的详细信息")
public class ClassRoomVoDTO {
    @ApiModelProperty("教室的基本信息")
    @NotNull(message = "教室的基本信息不能为空")
    private ClassRoomDTO classRoomInfo;
    @ApiModelProperty("教室的机床信息列表")
    @NotEmpty(message = "教室的机床信息列表不能为空")
    private List<MachineInfoDTO> machineInfoList;
}
