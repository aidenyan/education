package com.jimmy.student.api.websocket;

import com.jimmy.mvc.common.model.enums.CommandTypeEnum;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName: WebSocketUtils
 * @Description:
 * @author: aiden
 * @date: 2019/6/17/017.
 */
public class WebSocketUtils {
    public static Map<Long, WebSocket> webSocketMap = new HashMap<>();

    public static synchronized void add(Long machineId, WebSocket webSocket) {
        webSocketMap.put(machineId, webSocket);
    }

    public static synchronized void remove(Long machineId) {
        webSocketMap.remove(machineId);
    }
    public static List<Long> listMachineId() {
       return  webSocketMap.keySet().stream().collect(Collectors.toList());
    }
    public static void push(Object sendContent, CommandTypeEnum commadType, Collection<Long> machineIdList) {
        machineIdList.forEach(machineId->{
            try {
                webSocketMap.get(machineId).sendMessage(sendContent,commadType);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}
