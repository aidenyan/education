package com.jimmy.dao.entity;

import lombok.Data;

import java.util.Date;

@Data
public class CourseInfo extends BaseEntity {

    /**
     * �γ̵�����
     */
    private String name;
    /**
     * �γ̿�ʼʱ��
     */
    private Date startTime;
    /**
     * �γ�ʱ�䳤��
     */
    private Integer timeLong;
    /**
     * ����ID
     */
    private Long roomId;
    /**
     * ��ʦID
     */
    private Long teacherId;
    /**
     * ʹ��״̬
     */
    private Integer usedStatus;
    /**
     * ����
     */
    private String description;
    /**
     * ʹ�õ���ʦ
     */
    private Long usedTeacherId;

}