package com.jimmy.dao.entity;

import java.util.Date;

public class SiteInfo {
    private Long id;

    private String domain;

    private Integer parentId;

    private String parentTree;

    private Byte childEnabled;

    private Byte deleted;

    private Date createTime;

    private Date modifyTime;

    private Long createId;

    private Long modifyId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain == null ? null : domain.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getParentTree() {
        return parentTree;
    }

    public void setParentTree(String parentTree) {
        this.parentTree = parentTree == null ? null : parentTree.trim();
    }

    public Byte getChildEnabled() {
        return childEnabled;
    }

    public void setChildEnabled(Byte childEnabled) {
        this.childEnabled = childEnabled;
    }

    public Byte getDeleted() {
        return deleted;
    }

    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public Long getModifyId() {
        return modifyId;
    }

    public void setModifyId(Long modifyId) {
        this.modifyId = modifyId;
    }
}