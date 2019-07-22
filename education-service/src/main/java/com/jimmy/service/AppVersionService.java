package com.jimmy.service;

import com.jimmy.dao.entity.AppVersion;

public interface AppVersionService {
    /**
     * 获取app信息
     *
     * @param appName
     * @return
     */
    AppVersion find(String appName);
}
