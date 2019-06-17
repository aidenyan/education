package com.jimmy.mvc.common.service;

import com.jimmy.mvc.common.model.enums.CommandTypeEnum;

/**
 * @ClassName: WebSocketService
 * @Description:
 * @author: aiden
 * @date: 2019/6/17/017.
 */
public interface WebSocketService {
    /**
     * ������Ϣ
     *
     * @param message
     * @param socketType
     */
    void dealMessage(Long sendId, String message, CommandTypeEnum socketType);
}
