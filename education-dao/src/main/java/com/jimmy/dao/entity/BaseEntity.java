package com.jimmy.dao.entity;

import lombok.Data;

import java.util.Date;

@Data
public class BaseEntity {
    /**
     * ID
     */
    private Long id;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date modifyTime;
    /**
     * 创建人
     */
    private Long createId;
    /**
     * 修改人
     */
    private Long modifyId;
    /**
     * 站点
     */
    private Long siteId;
}
