package com.jimmy.teacher.api.websocket;

import com.jimmy.mvc.common.model.dto.SendMessage;
import com.jimmy.mvc.common.model.enums.CommandTypeEnum;

import java.io.IOException;
import java.util.*;

/**
 * @ClassName: WebSocketUtils
 * @Description:
 * @author: aiden
 * @date: 2019/6/17/017.
 */
public class WebSocketUtils {
    public static Map<Long, WebSocket> webSocketMap = new HashMap<>();

    public static Map<Long, List<SendMessage>> sendMessage = new HashMap<>();

    public static synchronized void add(Long theacherId, WebSocket webSocket) {
        webSocketMap.put(theacherId, webSocket);
        synchronized (sendMessage) {
            List<SendMessage> teacherSendMessages = sendMessage.get(theacherId);
            if (teacherSendMessages != null) {
                sendMessage.remove(theacherId);
                teacherSendMessages.forEach(teacherSendMessage -> {
                    try {
                        webSocket.sendMessage(teacherSendMessage.getSendContent(), teacherSendMessage.getCommadType());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        }
    }

    public static synchronized void remove(Long theacherId) {
        webSocketMap.remove(theacherId);
    }

    public static void push(Object sendContent, CommandTypeEnum commadType, Collection<Long> theacherIdList) {
        theacherIdList.forEach(theacherId -> {
            try {
                if (webSocketMap.get(theacherId) != null) {
                    webSocketMap.get(theacherId).sendMessage(sendContent, commadType);
                } else {
                    synchronized (sendMessage) {
                        SendMessage teacherSendMessage = new SendMessage();
                        teacherSendMessage.setCommadType(commadType);
                        teacherSendMessage.setSendContent(sendContent);
                        List<SendMessage> teacherSendMessages = sendMessage.get(theacherId);
                        if (teacherSendMessages == null) {
                            teacherSendMessages = new ArrayList<>();
                            sendMessage.put(theacherId, teacherSendMessages);
                        }
                        teacherSendMessages.add(teacherSendMessage);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
