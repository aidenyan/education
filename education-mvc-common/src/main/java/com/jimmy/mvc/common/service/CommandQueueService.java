package com.jimmy.mvc.common.service;

import com.jimmy.mvc.common.model.dto.CommandMessageDTO;

/**
 * @ClassName: CommandQueueService
 * @Description:
 * @author: aiden
 * @date: 2019/6/17/017.
 */
public interface CommandQueueService {
    /**
     * 加入队列
     */
    void push(CommandMessageDTO commandMessageDTO);


    /**
     * 获取命令
     */
    CommandMessageDTO poll();

    /**
     * 发送消息
     *
     * @param commandMessageDTO
     */
    void sendMessage(CommandMessageDTO commandMessageDTO);
}
