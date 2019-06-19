package com.jimmy.dao.entity;

import lombok.Data;

import java.util.Date;

@Data
public class CourseInfo extends BaseEntity {

    /**
     * 课程的名字
     */
    private String name;
    /**
     * 课程开始时间
     */
    private Date startTime;
    /**
     * 课程时间长度
     */
    private Integer timeLong;
    /**
     * 教室ID
     */
    private Long roomId;
    /**
     * 教师ID
     */
    private Long teacherId;
    /**
     * 使用状态
     */
    private Integer usedStatus;
    /**
     * 描述
     */
    private String description;
    /**
     * 使用的老师
     */
    private Long usedTeacherId;

}