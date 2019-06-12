package com.jimmy.mvc.common.model.dto;

import lombok.Data;

import java.util.List;

/**
 * @ClassName: MachineStudentDTO
 * @Description:
 * @author: aiden
 * @date: 2019/6/12/012.
 */
@Data
public class MachineStudentDTO {
    /**
     * 机器ID
     */
    private Long machineId;
    /**
     * 课件ID
     */
    private Long courewareId;
    /**
     * 学生列表
     */
    private List<Long> studentIdList;
}
