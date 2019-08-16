package com.jimmy.mvc.common.model.dto;

import com.jimmy.mvc.common.model.enums.CommandTypeEnum;
import lombok.Data;

@Data
public class SendMessage {
    private Object sendContent;
    private CommandTypeEnum commadType;
}
