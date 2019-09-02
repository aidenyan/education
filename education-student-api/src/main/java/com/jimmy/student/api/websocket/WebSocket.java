package com.jimmy.student.api.websocket;

import com.alibaba.fastjson.JSON;
import com.jimmy.common.utils.StringUtils;
import com.jimmy.dao.entity.MachineInfo;
import com.jimmy.mvc.common.model.dto.SocketMessage;
import com.jimmy.mvc.common.model.enums.CommandTypeEnum;
import com.jimmy.mvc.common.service.WebSocketService;
import com.jimmy.service.ClassRoomService;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;


@ServerEndpoint("/websocket")
@Component
public class WebSocket {


    //�˴��ǽ���޷�ע��Ĺؼ�
    private static ApplicationContext applicationContext;
    //��ĳ���ͻ��˵����ӻỰ����Ҫͨ���������ͻ��˷�������
    private Session session;
    private Long machineId;

    private WebSocketService webSocketService;

    private ClassRoomService classRoomService;

    public static void setApplicationContext(ApplicationContext applicationContext) {
        WebSocket.applicationContext = applicationContext;
    }

    public ClassRoomService getClassRoomService() {
        if (classRoomService == null) {
            classRoomService = WebSocket.applicationContext.getBean(ClassRoomService.class);
        }
        return classRoomService;
    }

    public WebSocketService getWebSocketService() {
        if (webSocketService == null) {
            webSocketService = WebSocket.applicationContext.getBean(WebSocketService.class);
        }
        return webSocketService;

    }

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
        try {
            Assert.isTrue(StringUtils.isNotBlank(message));
            SocketMessage socketMessage = JSON.parseObject(message, SocketMessage.class);
            if (CommandTypeEnum.INIT == socketMessage.getSocketType()) {
                this.machineId = Long.parseLong(String.valueOf(socketMessage.getResult()));
                MachineInfo machineInfo = getClassRoomService().findMachine(machineId);
                if (machineInfo == null) {
                    sendFailMessage("machine id is not exist", CommandTypeEnum.INIT);
                    return;
                }
                WebSocketUtils.add(machineId, this, machineInfo.getRoomId());
                try {
                    sendMessage(null, CommandTypeEnum.INIT);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            } else {
                getWebSocketService().dealMessage(machineId, JSON.toJSONString(socketMessage.getResult()), socketMessage.getSocketType());
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
     * ��������ʱ����
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {

    }

    /**
     * ������������漸��������һ����û����ע�⣬�Ǹ����Լ���Ҫ��ӵķ�����
     */
    public void sendFailMessage(Object messageObj, CommandTypeEnum socketType) throws IOException {
        Assert.notNull(messageObj);
        Assert.notNull(socketType);
        SocketMessage socketMessage = new SocketMessage();
        socketMessage.setCode("500");
        socketMessage.setResult(messageObj);
        socketMessage.setSocketType(socketType);
        this.session.getBasicRemote().sendText(JSON.toJSONString(socketMessage));
    }

    /**
     * ������������漸��������һ����û����ע�⣬�Ǹ����Լ���Ҫ��ӵķ�����
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
