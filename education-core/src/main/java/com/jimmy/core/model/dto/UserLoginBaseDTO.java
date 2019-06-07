package com.jimmy.core.model.dto;

import lombok.Data;

@Data
public class UserLoginBaseDTO {
    /**
     * 用户ID
     */
    private Long useId;
    /**
     * 用户的TOKEN
     */
    private String token;

}
