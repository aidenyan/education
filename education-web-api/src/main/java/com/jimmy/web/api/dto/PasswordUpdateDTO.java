package com.jimmy.web.api.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

@Data
public class PasswordUpdateDTO implements Serializable {
    private static final long serialVersionUID = -903879615975824513L;
    @NotEmpty(message = "老密码不能为空")
    private String oldPassword;
    @NotEmpty(message = "新密码不能为空")
    private String password;
    @NotEmpty(message = "真实的名字不能为空")
    private String realName;
}
