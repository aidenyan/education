package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @ClassName: MachineStudentDTO
 * @Description:
 * @author: aiden
 * @date: 2019/6/12/012.
 */
@Data
@Api("机床与学生关系信息")
public class MachineStudentDTO {
    /**
     * 机器ID
     */
    @NotNull(message = "机器ID不能为空")
    @ApiModelProperty("机器ID")
    private Long machineId;
    /**
     * 课件ID
     */
    @NotNull(message = "课件ID不能为空")
    @ApiModelProperty("课件ID")
    private Long courewareId;
    /**
     * 学生列表
     */
    @NotNull(message = "学生列表不能为空")
    @ApiModelProperty("学生列表")
    private List<Long> studentIdList;
}
