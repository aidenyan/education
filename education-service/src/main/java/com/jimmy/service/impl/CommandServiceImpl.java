package com.jimmy.service.impl;

import com.jimmy.core.local.thread.LoginLocalThread;
import com.jimmy.dao.entity.CommandInfo;
import com.jimmy.dao.local.thread.SiteLocalThread;
import com.jimmy.dao.mapper.CommandInfoMapper;
import com.jimmy.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;


/**
 * @ClassName: CommandServiceImpl
 * @Description:
 * @author: aiden
 * @date: 2019/6/17/017.
 */
@Service
@Transactional(readOnly = true)
public class CommandServiceImpl implements CommandService {

    @Autowired
    private CommandInfoMapper commandInfoMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long save(CommandInfo commandInfo) {
        Assert.notNull(commandInfo, "commandInfo is null");
        commandInfo.setModifyId(LoginLocalThread.get());
        commandInfo.setCreateId(LoginLocalThread.get());
        commandInfo.setSiteId(SiteLocalThread.getSiteId());
        commandInfoMapper.insert(commandInfo);
        return commandInfo.getId();
    }
}
