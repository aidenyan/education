package com.jimmy.dao.entity;

import lombok.Data;

@Data
public class Courseware extends BaseEntity {
    /**
     * 课件的名字
     */
    private String name;
    /**
     * 是否已经使用
     */
    private Boolean isUsed;
    /**
     * 课件的描述
     */
    private String description;
    /**
     * 课件等级
     */
    private Integer levelNum;


}