package com.jimmy.service.impl;

import com.jimmy.core.local.thread.LoginLocalThread;
import com.jimmy.dao.entity.CommandInfo;
import com.jimmy.dao.entity.TemporaryClassMate;
import com.jimmy.dao.local.thread.SiteLocalThread;
import com.jimmy.dao.mapper.CommandInfoMapper;
import com.jimmy.service.CommandService;
import com.jimmy.service.TemporaryClassMateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;


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

    @Autowired
    private TemporaryClassMateService temporaryClassMateService;

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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long saveAskLevelByMachine(CommandInfo commandInfo, Boolean isAskLevel) {
        Long commandId = save(commandInfo);
        TemporaryClassMate temporaryClassMate = temporaryClassMateService.findTempClassMate(commandInfo.getCourseId());
        temporaryClassMateService.updateAskLevelByMachine(isAskLevel,commandInfo.getOperationId(),temporaryClassMate.getId());
        return commandId;
    }

    @Override
    public List<CommandInfo> list(Long courseId, List<Integer> typeList) {
        return commandInfoMapper.list(courseId, typeList, SiteLocalThread.getSiteIdList());
    }
}
