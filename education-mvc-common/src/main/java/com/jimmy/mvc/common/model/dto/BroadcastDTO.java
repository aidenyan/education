package com.jimmy.mvc.common.model.dto;

import com.jimmy.mvc.common.model.enums.ReceiveTypeEnum;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

/**
 * @ClassName: BroadcastDTO
 * @Description:
 * @author: aiden
 * @date: 2019/6/17/017.
 */
@Data
@ApiModel("π„≤•–≈œ¢")
public class BroadcastDTO {
    private ReceiveTypeEnum receiveType;
    private List<Long> machineIdList;
    private String content;
}
