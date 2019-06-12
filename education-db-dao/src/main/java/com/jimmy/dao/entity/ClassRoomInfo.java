package com.jimmy.dao.entity;

import lombok.Data;

@Data
public class ClassRoomInfo extends BaseEntity {
    /**
     * ���ұ��
     */
    private String sn;
    /**
     * ��������
     */
    private String name;
    /**
     * ���Ҿ����ַ
     */
    private String address;
    /**
     * �Ƿ��Ѿ�ɾ��
     */
    private Boolean isDeleted;
    /**
     * ����
     */
    private String description;


}