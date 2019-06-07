package com.jimmy.dao.entity;

import lombok.Data;

@Data
public class MenuInfo extends BaseEntity {


    private String urlPath;

    private String code;

    private Byte menuType;

    private Short parentMenuId;

    private String name;

    private String menuUrl;

    private Byte menuLevel;

    private Short orderNum;

    private Byte deleted;


}