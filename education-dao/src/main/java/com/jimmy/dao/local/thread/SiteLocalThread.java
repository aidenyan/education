package com.jimmy.dao.local.thread;

import java.util.List;

public class SiteLocalThread {
    private static ThreadLocal<Long> siteIdThreadLocal = new ThreadLocal<Long>();

    private static ThreadLocal<List<Long>> siteIdListThreadLocal = new ThreadLocal<>();

    public static Long getSiteId() {
        return siteIdThreadLocal.get();
    }

    public static void set(Long siteId) {
        siteIdThreadLocal.set(siteId);
    }


    public static List<Long> getSiteIdList() {
        return siteIdListThreadLocal.get();
    }

    public static void set(List<Long> siteIdList) {
        siteIdListThreadLocal.set(siteIdList);
    }
}
