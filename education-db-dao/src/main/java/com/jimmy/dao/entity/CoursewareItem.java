package com.jimmy.dao.entity;

import lombok.Data;

@Data
public class CoursewareItem extends BaseEntity {

    /**
     * 课件类型，0:资源，1:题库
     */
    private Integer type;
    /**
     * 如果type为0，0：图片，1：视频，2:文字；3：图纸；如果未1：5：问答题，6:单选题，7.多选题
     */
    private Integer contentType;
    /**
     * 如果type为0则为资源ID,为1则为题库ID
     */
    private Long resourceId;
    /**
     * 内容对象为具体内容的一个JSON对象
     */
    private String content;
    /**
     * 排序
     */
    private Integer orderNum;
    /**
     * 课件ID
     */
    private Long coursewareId;


}