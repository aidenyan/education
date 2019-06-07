package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.SysLogInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SysLogInfoMapper {
    /**
     * 保存系统日志信息
     *
     * @param sysLogInfo 系统日志
     * @return 保存结果
     */
    int insert(SysLogInfo sysLogInfo);

    /**
     * @param id         ID
     * @param siteIdList 站点ID列表
     * @return 系统日志详细信息
     */
    SysLogInfo findById(@Param("id") Long id, @Param("siteIdList") List<Long> siteIdList);

    /**
     * @param startDate    结束时间
     * @param endDate      开始时间
     * @param operationSys 操作系统
     * @param logType      日志类型
     * @param siteIdList   站点ID列表
     * @return List<日志信息>
     */
    List<SysLogInfo> list(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("operationSys") Integer operationSys, @Param("logType") Integer logType, @Param("siteIdList") List<Long> siteIdList);

}