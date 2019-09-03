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
     * ����ָ��
     */
    Long save(CommandInfo commandInfo);

    /**
     * �������ָ��
     *
     * @param commandInfo
     * @param isAskLeve
     * @return
     */
    Long saveAskLevelByMachine(CommandInfo commandInfo, Boolean isAskLeve,Long studentId);

    /**
     * ��ȡĳ�����͵�������Ϣ
     */
    List<CommandInfo> list(Long courseId, List<Integer> typeList);

}
