package com.jimmy.mvc.common.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CookieValueDTO implements Serializable {
    private static final long serialVersionUID = 5860997021815902883L;
    private Long loginId;
    private Long time;
    private String key;
}
