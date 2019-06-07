package com.jimmy.service;

import com.jimmy.core.model.dto.UserLoginBaseDTO;

public interface TokenService {
    /**
     * 通过用户的ID和用户的token加密生成一个通讯的token
     *
     * @param userLoginBaseDTO 登录信息
     * @return 通讯token
     */
    String createToken(UserLoginBaseDTO userLoginBaseDTO);

    /**
     * 通过通讯token
     *
     * @param token 通讯token获取用户的ID和用户的token
     * @return 用户的ID和token的信息
     */
    UserLoginBaseDTO analysisToken(String token);
}
