package com.jimmy.dao.local.thread;

import com.jimmy.dao.local.model.dto.SysInfoDTO;

public class SysInfoLocalThread {
    private static ThreadLocal<SysInfoDTO> sysInfoThreadLocal = new ThreadLocal<SysInfoDTO>();


    public static SysInfoDTO get() {
        return sysInfoThreadLocal.get();
    }

    public static void set(SysInfoDTO sysInfoDTO) {
        sysInfoThreadLocal.set(sysInfoDTO);
    }
}
