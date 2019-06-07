package com.jimmy.core.local.thread;

public class LoginLocalThread {
    private static ThreadLocal<Long> loginUserIdThreadLocal = new ThreadLocal<Long>();

    public static Long get() {
        return loginUserIdThreadLocal.get();
    }

    public static void set(Long userId) {
        loginUserIdThreadLocal.set(userId);
    }
}
