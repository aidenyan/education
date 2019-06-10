package com.jimmy.dao.entity;

import lombok.Data;

@Data
public class Courseware extends BaseEntity {

    private String name;

    private Byte isUsed;


    private String description;


}