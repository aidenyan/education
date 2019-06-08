package com.jimmy.service;

import com.jimmy.dao.entity.SysLogInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SysLogInfoService {
    /**
     * 保存日hi信息
     * @param sysLogInfo 日志信息
     */
    void insert(SysLogInfo sysLogInfo);
    /**
     * @param id         ID
     * @return 系统日志详细信息
     */
    SysLogInfo findById( Long id);

    /**
     * @param startDate    结束时间
     * @param endDate      开始时间
     * @param operationSys 操作系统
     * @param logType      日志类型
     * @return List<日志信息>
     */
    List<SysLogInfo> list( Date startDate, Date endDate,  Integer operationSys,Integer logType);

}
