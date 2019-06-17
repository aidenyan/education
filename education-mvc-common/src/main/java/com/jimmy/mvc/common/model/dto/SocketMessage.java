package com.jimmy.mvc.common.model.dto;

import com.jimmy.mvc.common.model.enums.CommadTypeEnum;
import lombok.Data;

/**
 * @ClassName: SocketMessage
 * @Description:
 * @author: aiden
 * @date: 2019/6/17/017.
 */
@Data
public class SocketMessage {
    private Object result;
    private String code;
    private CommadTypeEnum socketType;
}
