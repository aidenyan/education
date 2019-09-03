package com.jimmy.mvc.common.model.dto;

import lombok.Data;

/**
 * @ClassName: RaiseHandDTO
 * @Description:
 * @author: aiden
 * @date: 2019/6/19/019.
 */
@Data

public class RaiseHandDTO {

    private Long teacherId;
    private Long machineId;
    private Long studentId;
    private String reason;
}
