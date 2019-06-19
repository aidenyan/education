package com.jimmy.student.api.websocket;

import com.alibaba.fastjson.JSON;
import com.jimmy.common.utils.StringUtils;
import com.jimmy.mvc.common.model.dto.SocketMessage;
import com.jimmy.mvc.common.model.enums.CommandTypeEnum;
import com.jimmy.mvc.common.service.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;


@ServerEndpoint("/websocket")
@Component
public class WebSocket {


    //��ĳ���ͻ��˵����ӻỰ����Ҫͨ���������ͻ��˷�������
    private Session session;

    private Long machineId;
    @Autowired
    private WebSocketService webSocketService;


    /**
     * ���ӽ����ɹ����õķ���
     *
     * @param session ��ѡ�Ĳ�����sessionΪ��ĳ���ͻ��˵����ӻỰ����Ҫͨ���������ͻ��˷�������
     */
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
    }

    /**
     * ���ӹرյ��õķ���
     */
    @OnClose
    public void onClose() {
        WebSocketUtils.remove(machineId);
    }

    /**
     * �յ��ͻ�����Ϣ����õķ���
     *
     * @param message �ͻ��˷��͹�������Ϣ
     * @param session ��ѡ�Ĳ���
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        Assert.isTrue(StringUtils.isNotBlank(message));
        SocketMessage socketMessage = JSON.parseObject(message, SocketMessage.class);
        if (CommandTypeEnum.INIT == socketMessage.getSocketType()) {
            this.machineId = (Long) socketMessage.getResult();
            WebSocketUtils.add(machineId, this);
        } else {
            webSocketService.dealMessage(machineId, JSON.toJSONString(socketMessage.getResult()), socketMessage.getSocketType());
        }
    }

    /**
     * ��������ʱ����
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {

    }

    /**
     * ������������漸��������һ����û����ע�⣬�Ǹ����Լ���Ҫ���ӵķ�����
     */
    public void sendMessage(Object messageObj, CommandTypeEnum socketType) throws IOException {
        Assert.notNull(messageObj);
        Assert.notNull(socketType);
        SocketMessage socketMessage = new SocketMessage();
        socketMessage.setCode("200");
        socketMessage.setResult(messageObj);
        socketMessage.setSocketType(socketType);
        this.session.getBasicRemote().sendText(JSON.toJSONString(socketMessage));
    }


}