package com.jimmy.dao.entity;

import lombok.Data;

import java.util.Date;
@Data
public class DictionaryItem extends BaseEntity{

    /**
     * 评价的几项的字典
     */
    private Long dictionaryId;

    private String content;


}