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
     * �������
     */
    void push(CommandMessageDTO commandMessageDTO);


    /**
     * ��ȡ����
     */
    CommandMessageDTO poll();

    /**
     * ������Ϣ
     *
     * @param commandMessageDTO
     */
    void sendMessage(CommandMessageDTO commandMessageDTO);
}
