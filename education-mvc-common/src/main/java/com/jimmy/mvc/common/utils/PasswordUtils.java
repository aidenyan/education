package com.jimmy.mvc.common.utils;

import com.jimmy.common.utils.EncryptUtils;
import com.jimmy.common.utils.StringUtils;

public class PasswordUtils {

    private final static String PASSWORD_ENCRY_KEY = PasswordUtils.class.getName() + "PASSWORD_ENCRY_KEY";

    public static Boolean isEquals(String password, String encryPassword) {
        if (StringUtils.isBlank(password) || StringUtils.isBlank(encryPassword)) {
            return false;
        }
        password = EncryptUtils.encryptMd5(password, PASSWORD_ENCRY_KEY);
        return password.equals(encryPassword);

    }
}
