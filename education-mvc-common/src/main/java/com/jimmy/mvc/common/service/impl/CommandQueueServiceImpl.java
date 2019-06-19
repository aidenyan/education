package com.jimmy.mvc.common.service.impl;

import com.alibaba.fastjson.JSON;
import com.jimmy.common.utils.EncryptUtil;
import com.jimmy.common.utils.HttpUtils;
import com.jimmy.mvc.common.model.dto.CommandMessageDTO;
import com.jimmy.mvc.common.model.dto.CommandResultDTO;
import com.jimmy.mvc.common.service.CommandQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;

/**
 * @ClassName: CommandQueueService
 * @Description:
 * @author: aiden
 * @date: 2019/6/17/017.
 */
@Service
public class CommandQueueServiceImpl implements CommandQueueService {

    @Autowired
    private ExecutorService executorService;

    private Queue<CommandMessageDTO> queue = new LinkedList<>();


    @Override
    public void push(CommandMessageDTO commandMessageDTO) {
        queue.add(commandMessageDTO);
        executorService.execute(() -> sendMessage(poll()));
    }


    @Override
    public synchronized CommandMessageDTO poll() {
        return queue.poll();
    }


    public void sendMessage(CommandMessageDTO commandMessageDTO) {
        if (commandMessageDTO == null || commandMessageDTO.getCommandDTO() == null || commandMessageDTO.getCommandDTO().getCommandType() == null || !commandMessageDTO.getCommandDTO().getCommandType().isSend()) {
            return;
        }
        String result = null;
        try {
            String sn = commandMessageDTO.getCommandDTO().getSn();
            String token = EncryptUtil.encryptMd5(sn, commandMessageDTO.getToken());

            result = HttpUtils.post(commandMessageDTO.getSendUrl() + "/" + token, JSON.toJSONString(commandMessageDTO.getCommandDTO()));
            CommandResultDTO commandResultDTO = JSON.parseObject(result, CommandResultDTO.class);
            if (commandResultDTO.getResult() == null || !commandResultDTO.getResult()) {
                push(commandMessageDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
            push(commandMessageDTO);
        }

    }
}
