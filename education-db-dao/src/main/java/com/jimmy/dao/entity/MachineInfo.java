package com.jimmy.dao.entity;

import lombok.Data;

@Data
public class MachineInfo extends BaseEntity {
    /**
     * 教室ID
     */
    private Long roomId;
    /**
     * 编号
     */
    private String sn;
    /**
     * 行数
     */
    private Integer rowNum;
    /**
     * 列数
     */
    private Integer columnNum;


}