package com.jimmy.dao.entity;

import lombok.Data;

@Data
public class CoursewareItem extends BaseEntity {

    /**
     * �μ����ͣ�0:��Դ��1:���
     */
    private Integer type;
    /**
     * ���typeΪ0��0��ͼƬ��1����Ƶ��2:���֣�3��ͼֽ�����δ1��5���ʴ��⣬6:��ѡ�⣬7.��ѡ��
     */
    private Integer contentType;
    /**
     * ���typeΪ0��Ϊ��ԴID,Ϊ1��Ϊ���ID
     */
    private Long resourceId;
    /**
     * ���ݶ���Ϊ�������ݵ�һ��JSON����
     */
    private String content;
    /**
     * ����
     */
    private Integer orderNum;
    /**
     * �μ�ID
     */
    private Long coursewareId;


}