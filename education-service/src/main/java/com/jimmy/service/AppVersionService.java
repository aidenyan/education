package com.jimmy.service;

import com.jimmy.dao.entity.AppVersion;

public interface AppVersionService {
    /**
     * ��ȡapp��Ϣ
     *
     * @param appName
     * @return
     */
    AppVersion find(String appName);
}
