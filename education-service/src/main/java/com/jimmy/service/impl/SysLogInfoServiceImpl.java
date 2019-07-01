package com.jimmy.service.impl;

import com.jimmy.core.anno.DisabledLog;
import com.jimmy.core.base.Page;
import com.jimmy.dao.entity.SysLogInfo;
import com.jimmy.dao.local.thread.SiteLocalThread;
import com.jimmy.dao.mapper.SysLogInfoMapper;
import com.jimmy.service.SysLogInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class  SysLogInfoServiceImpl implements SysLogInfoService {

    @Autowired
    private SysLogInfoMapper sysLogInfoMapper;

    @Override
    @DisabledLog
    @Transactional(rollbackFor = Exception.class)
    public void insert(SysLogInfo sysLogInfo) {
        sysLogInfoMapper.insert(sysLogInfo);
    }

    @Override
    public SysLogInfo findById(Long id) {
        Assert.notNull(id, "id is null");
        return sysLogInfoMapper.findById(id, SiteLocalThread.getSiteIdList());
    }

    @Override
    public List<SysLogInfo> list(Date startDate, Date endDate, Integer operationSys, Integer logType) {
        return sysLogInfoMapper.list(startDate, endDate, operationSys, logType, SiteLocalThread.getSiteIdList());
    }


}
