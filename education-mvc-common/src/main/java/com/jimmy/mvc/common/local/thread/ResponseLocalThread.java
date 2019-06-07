package com.jimmy.mvc.common.local.thread;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseLocalThread {
    private static ThreadLocal<HttpServletResponse> responseThreadLocal = new ThreadLocal<>();

    public static HttpServletResponse get() {
        return responseThreadLocal.get();
    }

    public static void set(HttpServletResponse httpServletResponse) {
        responseThreadLocal.set(httpServletResponse);
    }
}
