package com.jimmy.dao.entity;

import lombok.Data;

@Data
public class CourseStudent extends BaseEntity {

    /**
     * �γ�ID
     */
    private Long courseId;
    /**
     * ����ID
     */
    private Long machineId;
    /**
     * ѧ��ID
     */
    private Long studentId;
    /**
     * ״̬0���γ̻����ֲ���ɣ�1:�γ����
     */
    private Integer status;

}