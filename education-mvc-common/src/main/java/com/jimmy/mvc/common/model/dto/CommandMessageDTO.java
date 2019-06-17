package com.jimmy.mvc.common.model.dto;

import lombok.Data;

/**
 * @ClassName: CommandMessageDTO
 * @Description:
 * @author: aiden
 * @date: 2019/6/17/017.
 */
@Data
public class CommandMessageDTO {
    private CommandDTO commandDTO;
    private String sendUrl;
    private String token;
}
