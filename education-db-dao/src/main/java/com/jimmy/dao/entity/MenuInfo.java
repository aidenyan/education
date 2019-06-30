package com.jimmy.dao.entity;

import lombok.Data;

@Data
public class MenuInfo extends BaseEntity {


    private String urlPath;

    private String code;

    private Integer menuType;

    private Short parentMenuId;

    private String name;

    private String menuUrl;

    private Integer menuLevel;

    private Short orderNum;

    private Boolean deleted;


}