package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.AppVersion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppVersionMapper {
    /**
     * 获取最新版本信息
     *
     * @param appName
     * @param siteIdList
     * @return
     */
    AppVersion findByAppName(@Param("appName") String appName, @Param("siteIdList") List<Long> siteIdList);

    /**
     * 保存最新版本信息
     */
    int insert(AppVersion appVersion);

    /**
     * 更新版本需要更新的属性信息
     */
    int updateProperty(AppVersion appVersion);


    /**
     * 根据名字搜索信息
     */
    List<AppVersion> list(@Param("name") String name, @Param("siteIdList") List<Long> siteIdList);
}