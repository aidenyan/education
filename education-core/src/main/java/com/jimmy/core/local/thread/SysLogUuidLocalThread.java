package com.jimmy.core.local.thread;

public class SysLogUuidLocalThread {
    private static ThreadLocal<String> sysLogUuidLocalThread = new ThreadLocal<String>();

    public static String get() {
        return sysLogUuidLocalThread.get();
    }

    public static void set(String uuid) {
        sysLogUuidLocalThread.set(uuid);
    }

}
