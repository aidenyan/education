package com.jimmy.service;


import com.jimmy.dao.entity.CommandInfo;

import java.util.List;

/**
 * @ClassName: CommandService
 * @Description:
 * @author: aiden
 * @date: 2019/6/17/017.
 */
public interface CommandService {
    /**
     * 保存指令
     */
    Long save(CommandInfo commandInfo);

    /**
     * 处理请假指令
     *
     * @param commandInfo
     * @param isAskLeve
     * @return
     */
    Long saveAskLevelByMachine(CommandInfo commandInfo, Boolean isAskLeve,Long studentId);

    /**
     * 获取某个类型的命令信息
     */
    List<CommandInfo> list(Long courseId, List<Integer> typeList);

}
