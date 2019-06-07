package com.jimmy.service.impl;

import com.jimmy.core.anno.DisabledLog;
import com.jimmy.dao.entity.SysLogInfo;
import com.jimmy.dao.mapper.SysLogInfoMapper;
import com.jimmy.service.SysLogInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class SysLogInfoServiceImpl implements SysLogInfoService {

    @Autowired
    private SysLogInfoMapper sysLogInfoMapper;

    @Override
    @DisabledLog
    @Transactional(rollbackFor = Exception.class)
    public void insert(SysLogInfo sysLogInfo) {
        sysLogInfoMapper.insert(sysLogInfo);
    }
}
