package com.jimmy.service;

import com.jimmy.dao.local.model.dto.SysInfoDTO;

public interface SysInfoService {
    /**
     * 查系统配置信息
     *
     * @return 系统的配置信息
     */
    SysInfoDTO find();

    /**
     * 保存系统配置信息
     *
     * @param sysInfoDTO 系统配置信息
     */
    void save(SysInfoDTO sysInfoDTO);
}
