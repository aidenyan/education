package com.jimmy.service;

import com.jimmy.dao.entity.SysLogInfo;

public interface SysLogInfoService {
    /**
     * 保存日hi信息
     * @param sysLogInfo 日志信息
     */
    void insert(SysLogInfo sysLogInfo);
}
