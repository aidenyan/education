package com.jimmy.teacher.api.websocket;

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


    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    private Long teacherId;
    @Autowired
    private WebSocketService webSocketService;


    /**
     * 连接建立成功调用的方法
     *
     * @param session 可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        WebSocketUtils.remove(teacherId);
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     * @param session 可选的参数
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        Assert.isTrue(StringUtils.isNotBlank(message));
        try {
            SocketMessage socketMessage = JSON.parseObject(message, SocketMessage.class);
            if (CommandTypeEnum.INIT == socketMessage.getSocketType()) {
                this.teacherId = Long.parseLong(String.valueOf(socketMessage.getResult()));
                WebSocketUtils.add(teacherId, this);
                try {
                    sendMessage(null, CommandTypeEnum.INIT_SUCCESS);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            } else {
                webSocketService.dealMessage(teacherId, JSON.toJSONString(socketMessage.getResult()), socketMessage.getSocketType());
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                sendFailMessage(e.getMessage(), CommandTypeEnum.INIT);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * 发生错误时调用
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

    /**
     * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
     */
    public void sendFailMessage(Object messageObj, CommandTypeEnum socketType) throws IOException {
        Assert.notNull(socketType);
        SocketMessage socketMessage = new SocketMessage();
        socketMessage.setCode("500");
        socketMessage.setResult(messageObj);
        socketMessage.setSocketType(socketType);
        this.session.getBasicRemote().sendText(JSON.toJSONString(socketMessage));
    }

    /**
     * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
     */
    public void sendMessage(Object messageObj, CommandTypeEnum socketType) throws IOException {
        Assert.notNull(socketType);
        SocketMessage socketMessage = new SocketMessage();
        socketMessage.setCode("0");
        socketMessage.setResult(messageObj);
        socketMessage.setSocketType(socketType);
        this.session.getBasicRemote().sendText(JSON.toJSONString(socketMessage));
    }


}
