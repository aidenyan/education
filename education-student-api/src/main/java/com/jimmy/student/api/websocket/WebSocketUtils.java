package com.jimmy.student.api.websocket;

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
    public static Map<Long, Set<Long>> roomMachineIdMap = new HashMap<>();
    public static Map<Long, List<SendMessage>> sendMessage = new HashMap<>();

    public static synchronized void add(Long machineId, WebSocket webSocket, Long roomId) {

        webSocketMap.put(machineId, webSocket);
        synchronized (sendMessage) {
            Set<Long> machineIdSet = roomMachineIdMap.get(roomId);
            if (machineIdSet == null) {
                machineIdSet = new HashSet<>();
                roomMachineIdMap.put(roomId,machineIdSet);
            }
            machineIdSet.add(machineId);
            List<SendMessage> teacherSendMessages = sendMessage.get(machineId);
            if (teacherSendMessages != null) {
                sendMessage.remove(machineId);
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

    public static synchronized void remove(Long machineId) {
        webSocketMap.remove(machineId);

    }

    public static Set<Long> listMachineId(Long roomId) {
        return roomMachineIdMap.get(roomId);
    }

    public static void push(Object sendContent, CommandTypeEnum commadType, Collection<Long> machineIdList) {
        machineIdList.forEach(machineId -> {
            try {

                if (webSocketMap.get(machineId) != null) {
                    webSocketMap.get(machineId).sendMessage(sendContent, commadType);
                } else {
                    synchronized (sendMessage) {
                        SendMessage teacherSendMessage = new SendMessage();
                        teacherSendMessage.setCommadType(commadType);
                        teacherSendMessage.setSendContent(sendContent);
                        List<SendMessage> teacherSendMessages = sendMessage.get(machineId);
                        if (teacherSendMessages == null) {
                            teacherSendMessages = new ArrayList<>();
                            sendMessage.put(machineId, teacherSendMessages);
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
