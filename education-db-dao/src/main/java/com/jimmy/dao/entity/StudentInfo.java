package com.jimmy.dao.entity;

import lombok.Data;

import java.util.Date;

@Data
public class StudentInfo extends BaseEntity {

    /**
     * IC��
     */
    private String idCard;
    /**
     * �༶ID
     */
    private Long classmateId;
    /**
     * ����
     */
    private String name;
    /**
     * �Ա�
     */
    private Integer sex;
    /**
     * email
     */
    private String email;
    /**
     * �Ƿ���Ч
     */
    private Boolean isEnabled;
    /**
     * ����
     */
    private String password;
    /**
     * ��ʵ������
     */
    private String realName;
    /**
     * ͷ����ƬID
     */
    private String headerUrl;
    /**
     * ����
     */
    private Date birthTime;
    /**
     * �ֻ�����
     */
    private String mobile;
    /**
     * �绰����
     */
    private String telephone;
    /**
     * token
     */
    private String appToken;
    /**
     * �Ƿ��Ѿ�ɾ��
     */
    private Boolean isDeleted;
    /**
     * ͷ������
     */
    private String headerInfo;

    /**
     * ����ID
     */
    private Long machineId;
    /**
     * �����汾
     */
    private Integer faceVersion;
}