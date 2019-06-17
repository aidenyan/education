package com.jimmy.mvc.common.model.dto;

import com.jimmy.mvc.common.model.enums.CommandTypeEnum;
import lombok.Data;

/**
 * @ClassName: PushCommandDTO
 * @Description:
 * @author: aiden
 * @date: 2019/6/17/017.
 */
@Data
public class PushCommandDTO {
    private CommandTypeEnum commadType;
    private String content;
}
