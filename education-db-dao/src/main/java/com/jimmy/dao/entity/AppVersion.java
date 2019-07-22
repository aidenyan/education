package com.jimmy.dao.entity;

import lombok.Data;

import java.util.Date;

@Data
public class AppVersion extends BaseEntity {

    /**
     * app������
     */
    private String appName;
    /**
     * ��������
     */
    private String downloadUrl;
    /**
     * �汾ʱ��
     */
    private String versionCode;
    /**
     * �汾����
     */
    private String  versionName;
    /**
     * �İ�
     */
    private String releaseNote;

}