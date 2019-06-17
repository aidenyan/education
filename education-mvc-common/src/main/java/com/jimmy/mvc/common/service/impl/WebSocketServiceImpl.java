package com.jimmy.mvc.common.service.impl;

import com.jimmy.mvc.common.model.enums.CommadTypeEnum;
import com.jimmy.mvc.common.service.WebSocketService;
import org.springframework.stereotype.Service;

/**
 * @ClassName: WebSocketServiceImpl
 * @Description:
 * @author: aiden
 * @date: 2019/6/17/017.
 */
@Service
public class WebSocketServiceImpl implements WebSocketService {


    @Override
    public void dealMessage(Long sendId, String message, CommadTypeEnum socketType) {

    }
}
