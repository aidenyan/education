package com.jimmy.dao.entity;

import lombok.Data;

@Data
public class Courseware extends BaseEntity {
    /**
     * �μ�������
     */
    private String name;
    /**
     * �Ƿ��Ѿ�ʹ��
     */
    private Boolean isUsed;
    /**
     * �μ�������
     */
    private String description;
    /**
     * �μ��ȼ�
     */
    private Integer levelNum;


}