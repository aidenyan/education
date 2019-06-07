package com.jimmy.service.impl;

import com.jimmy.common.utils.EncryptUtils;
import com.jimmy.common.utils.StringUtils;
import com.jimmy.core.model.dto.UserLoginBaseDTO;
import com.jimmy.service.TokenService;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class TokenServiceImpl implements TokenService {
    private final static String SNCRYPT_KEY = TokenServiceImpl.class.getName();

    @Override
    public String createToken(UserLoginBaseDTO userLoginBaseDTO) {
        Assert.notNull(userLoginBaseDTO, "userLoginBaseDTO is null");
        Assert.notNull(userLoginBaseDTO.getUseId(), "userId is null");
        Assert.isTrue(StringUtils.isNotBlank(userLoginBaseDTO.getToken()), "user token is null");
        String encrityToken = EncryptUtils.encryptMd5(userLoginBaseDTO.getToken(), SNCRYPT_KEY);
        String token = encrityToken + "_" + userLoginBaseDTO.getUseId() + "_" + userLoginBaseDTO.getToken();
        return token;
    }

    @Override
    public UserLoginBaseDTO analysisToken(String token) {
        Assert.isTrue(StringUtils.isNotBlank(token), "token is null");
        String[] tokenArray = token.split("_");
        if (tokenArray.length != 3) {
            return null;
        }
        UserLoginBaseDTO userLoginBaseDTO = new UserLoginBaseDTO();
        userLoginBaseDTO.setToken(tokenArray[2]);
        userLoginBaseDTO.setUseId(Long.parseLong(tokenArray[1]));
        String encrityToken = EncryptUtils.encryptMd5(userLoginBaseDTO.getToken(), SNCRYPT_KEY);
        if (encrityToken.equals(tokenArray[0])) {
            return userLoginBaseDTO;
        }
        return null;
    }
}
