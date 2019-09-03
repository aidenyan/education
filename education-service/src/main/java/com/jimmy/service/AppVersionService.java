package com.jimmy.service;

import com.jimmy.dao.entity.AppVersion;

import java.util.List;

public interface AppVersionService {
    /**
     * 获取app信息
     *
     * @param appName
     * @return
     */
    AppVersion find(String appName);

    List<AppVersion> list(String appName);

    AppVersion find(Long id);

    void update(AppVersion appVersion);

    void save(AppVersion appVersion);
}
