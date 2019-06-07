package com.jimmy.mvc.common.local.thread;

import javax.servlet.http.HttpServletRequest;

public class RequestLocalThread {
    private static ThreadLocal<HttpServletRequest> requestThreadLocal = new ThreadLocal<>();

    public static HttpServletRequest get() {
        return requestThreadLocal.get();
    }

    public static void set(HttpServletRequest httpServletRequest) {
        requestThreadLocal.set(httpServletRequest);
    }
}
