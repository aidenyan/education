package com.jimmy.dao.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CourseAnswer extends BaseEntity {

    /**
     * �γ�ID
     */
    private Long courseId;
    /**
     * ����ID
     */
    private Long machineId;
    /**
     * �μ�ID
     */
    private Long coursewareId;
    /**
     * �μ���ϸID
     */
    private Long coursewareItemId;
    /**
     * ����
     */
    private BigDecimal fraction;
    /**
     * ѧ���Ļش�
     */
    private String studentResult;
    /**
     * ��ʦ�Ļش�
     */
    private String tearchResult;

}