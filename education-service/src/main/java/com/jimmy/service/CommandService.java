package com.jimmy.service;


import com.jimmy.dao.entity.CommandInfo;

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
}
