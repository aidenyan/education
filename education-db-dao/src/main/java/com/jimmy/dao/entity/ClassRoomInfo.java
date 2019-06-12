package com.jimmy.dao.entity;

import lombok.Data;

@Data
public class ClassRoomInfo extends BaseEntity {

    private String sn;
    private String name;

    private String address;

    private Boolean isDeleted;

    private String description;


}