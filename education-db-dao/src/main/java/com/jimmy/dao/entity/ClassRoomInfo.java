package com.jimmy.dao.entity;

import lombok.Data;

@Data
public class ClassRoomInfo extends BaseEntity {
    /**
     * 教室编号
     */
    private String sn;
    /**
     * 教室名字
     */
    private String name;
    /**
     * 教室具体地址
     */
    private String address;
    /**
     * 是否已经删除
     */
    private Boolean isDeleted;
    /**
     * 描述
     */
    private String description;


}