package com.jimmy.mvc.common.model.dto;

import com.jimmy.dao.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("课程信息信息")
public class CourseStudentProcessDTO extends BaseEntity {


    private Long courseId;

    private Long machineId;

    private Long coursewareId;

    private Long coursewareItemId;

    private String coursewareItemName;

    private Date updateTime;

    private Long studentId;

    private Integer stepNum;

    private Boolean isEnd;

    private StudentInfoDTO studentInfoDTO;

    private CourseInfoDTO courseInfoDTO;


}