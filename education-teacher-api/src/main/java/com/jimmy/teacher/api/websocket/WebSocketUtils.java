package com.jimmy.teacher.api.websocket;

import com.jimmy.mvc.common.model.enums.CommandTypeEnum;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: WebSocketUtils
 * @Description:
 * @author: aiden
 * @date: 2019/6/17/017.
 */
public class WebSocketUtils {
    public static Map<Long, WebSocket> webSocketMap = new HashMap<>();

    public static synchronized void add(Long theacherId, WebSocket webSocket) {
        webSocketMap.put(theacherId, webSocket);
    }

    public static synchronized void remove(Long theacherId) {
        webSocketMap.remove(theacherId);
    }

    public static void push(Object sendContent, CommandTypeEnum commadType, Collection<Long> theacherIdList) {
        theacherIdList.forEach(theacherId -> {
            try {
                webSocketMap.get(theacherId).sendMessage(sendContent, commadType);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
