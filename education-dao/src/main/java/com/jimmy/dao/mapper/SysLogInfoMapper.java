package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.SysLogInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SysLogInfoMapper {

    int insert(SysLogInfo sysLogInfo);

    SysLogInfo findById(@Param("id")Long id,@Param("siteIdList") List<Long> siteIdList);

    List<SysLogInfo> list(@Param("startDate")Date startDate,@Param("endDate") Date endDate,@Param("operationSys") Integer operationSys, @Param("logType")Integer logType,@Param("siteIdList") List<Long> siteIdList);

}