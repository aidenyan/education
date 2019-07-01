package com.jimmy.web.api.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PasswordUpdateDTO implements Serializable {
    private static final long serialVersionUID = -903879615975824513L;
    private String oldPassword;
    private String password;
    private String realName;
}
