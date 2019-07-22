package com.jimmy.dao.entity;

import lombok.Data;

import java.util.Date;

@Data
public class AppVersion extends BaseEntity {

    /**
     * app的名字
     */
    private String appName;
    /**
     * 下载连接
     */
    private String downloadUrl;
    /**
     * 版本时间
     */
    private Integer versionCode;
    /**
     * 版本名字
     */
    private String  versionName;
    /**
     * 文案
     */
    private String releaseNote;

}