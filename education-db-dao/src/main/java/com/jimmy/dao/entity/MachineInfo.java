package com.jimmy.dao.entity;

import lombok.Data;

@Data
public class MachineInfo extends BaseEntity {
    /**
     * ����ID
     */
    private Long roomId;
    /**
     * ���
     */
    private String sn;
    /**
     * ����
     */
    private Integer rowNum;
    /**
     * ����
     */
    private Integer columnNum;


}