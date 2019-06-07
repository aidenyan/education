package com.jimmy.web.api.local.thread;

import com.jimmy.dao.entity.MenuInfo;

import java.util.List;

public class MenuInfoLocalThread {
    private static ThreadLocal<List<MenuInfo>> menuInfoListThreadLocal = new ThreadLocal<>();

    public static List<MenuInfo> get() {
        return menuInfoListThreadLocal.get();
    }

    public static void set(List<MenuInfo> menuInfoList) {
        menuInfoListThreadLocal.set(menuInfoList);
    }

}
