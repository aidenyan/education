package com.jimmy.web.api.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

@Data
public class PasswordUpdateDTO implements Serializable {
    private static final long serialVersionUID = -903879615975824513L;
    @NotEmpty(message = "�����벻��Ϊ��")
    private String oldPassword;
    @NotEmpty(message = "�����벻��Ϊ��")
    private String password;
    @NotEmpty(message = "��ʵ�����ֲ���Ϊ��")
    private String realName;
}
