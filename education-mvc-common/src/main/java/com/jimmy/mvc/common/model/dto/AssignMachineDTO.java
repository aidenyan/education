package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: AssignMachineDTO
 * @Description:
 * @author: aiden
 * @date: 2019/7/11/011.
 */
@Data
@Api("分配机床信息接口")
public class AssignMachineDTO implements Serializable {
    private static final long serialVersionUID = -5007948109099568386L;
    @NotNull(message = "课程ID不能为空")
    @ApiModelProperty("课程ID")
    private Long courseId;
    @ApiModelProperty("机床与学习信息分配关系")
    @NotEmpty(message = "机床与学习信息分配关系不能为空")
    private List<MachineStudentDTO> machineStudentsList;
}
