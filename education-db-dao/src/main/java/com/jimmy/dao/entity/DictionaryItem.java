package com.jimmy.dao.entity;

import lombok.Data;

import java.util.Date;
@Data
public class DictionaryItem extends BaseEntity{

    /**
     * ���۵ļ�����ֵ�
     */
    private Long dictionaryId;

    private String content;


}