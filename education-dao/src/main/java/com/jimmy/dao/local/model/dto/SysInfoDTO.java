package com.jimmy.dao.local.model.dto;

import lombok.Data;

@Data
public class SysInfoDTO {
    /**
     * 学校的名字
     */
    private String companyName;
    /**
     * 学校的电话
     */
    private String mobile;
    /**
     * 学校的地址
     */
    private String address;

}
