package com.jimmy.service.impl;

import com.jimmy.common.utils.BeanUtils;
import com.jimmy.core.local.thread.LoginLocalThread;
import com.jimmy.dao.entity.SysInfo;
import com.jimmy.dao.local.model.dto.SysInfoDTO;
import com.jimmy.dao.local.thread.SiteLocalThread;
import com.jimmy.dao.mapper.SysInfoMapper;
import com.jimmy.service.SysInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class SysInfoServiceImpl implements SysInfoService {
    @Autowired
    private SysInfoMapper sysInfoMapper;

    @Override
    public SysInfoDTO find() {
        List<SysInfo> sysInfoList = sysInfoMapper.list(SiteLocalThread.getSiteId());
        if (CollectionUtils.isEmpty(sysInfoList)) {
            return new SysInfoDTO();
        }
        SysInfoDTO sysInfoDTO = new SysInfoDTO();
        sysInfoList.forEach(sysInfo -> {
            BeanUtils.setFieldValue(sysInfoDTO, sysInfo.getSysKey(), sysInfo.getSysValue());
        });
        return sysInfoDTO;
    }

    @Override
    public void save(SysInfoDTO sysInfoDTO) {
        List<SysInfo> sysInfoList = sysInfoMapper.list(SiteLocalThread.getSiteId());
        if (CollectionUtils.isEmpty(sysInfoList)) {
            return;
        }
        sysInfoList.forEach(sysInfo -> {
            Object value = BeanUtils.getFieldValue(sysInfoDTO, sysInfo.getSysKey());
            sysInfo.setSysValue((String) value);
            sysInfo.setSiteId(SiteLocalThread.getSiteId());
            sysInfo.setModifyId(LoginLocalThread.get());
            sysInfoMapper.update(sysInfo);
        });

    }
}
