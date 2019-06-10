package com.jimmy.dao.entity;

import lombok.Data;

@Data
public class RoleInfo extends BaseEntity {

    private String name;

    private String roleDesc;

    private Boolean deleted;


}