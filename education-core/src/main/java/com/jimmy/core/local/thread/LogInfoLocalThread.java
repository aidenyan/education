package com.jimmy.core.local.thread;

import com.jimmy.core.anno.LogInfo;

public class LogInfoLocalThread {
    private static ThreadLocal<LogInfo> logInfoThreadLocal = new ThreadLocal<LogInfo>();

    public static LogInfo get() {
        return logInfoThreadLocal.get();
    }

    public static void set(LogInfo logInfo) {
        logInfoThreadLocal.set(logInfo);
    }
}
