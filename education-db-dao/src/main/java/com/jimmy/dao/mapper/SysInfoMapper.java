package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.SysInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysInfoMapper {

    /**
     * ����ϵͳ
     *
     * @param record ����ϵͳ
     * @return ��������
     */
    int update(SysInfo record);

    /**
     * ����վ��siteId��ѯϵͳ��Ϣ
     *
     * @param siteId վ��ID
     * @return list<ϵͳ��Ϣ/>
     */

    List<SysInfo> list(@Param("siteId") Long siteId);
}
