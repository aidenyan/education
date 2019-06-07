package com.jimmy.dao.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class SiteInfo implements Serializable{


    private String domain;

    private Integer parentId;

    private String parentTree;

    private Boolean childEnabled;

    private Boolean deleted;
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
    private Integer createId;
    /**
     * 修改人
     */
    private Integer modifyId;
   }