package com.jimmy.core.local.thread;

import com.jimmy.core.enums.OperationSysEnum;

public class OperationSysLocalThread {
    private static ThreadLocal<OperationSysEnum> sysLogUuidLocalThread = new ThreadLocal<OperationSysEnum>();

    public static OperationSysEnum get() {
        return sysLogUuidLocalThread.get();
    }

    public static void set(OperationSysEnum sysEnum) {
        sysLogUuidLocalThread.set(sysEnum);
    }

}
