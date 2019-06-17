package com.jimmy.teacher.api.websocket;

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
}
