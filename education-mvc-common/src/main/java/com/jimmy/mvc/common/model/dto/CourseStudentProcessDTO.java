package com.jimmy.mvc.common.model.dto;

import com.jimmy.dao.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("课程信息信息")
public class CourseStudentProcessDTO extends BaseEntity {

    @ApiModelProperty("课程ID")
    private Long courseId;
    @ApiModelProperty("机床ID")
    private Long machineId;
    @ApiModelProperty("课件ID")
    private Long coursewareId;
    @ApiModelProperty("课件详细ID")
    private Long coursewareItemId;
    @ApiModelProperty("课件详细名字")
    private String coursewareItemName;
    @ApiModelProperty("更新时间")
    private Date updateTime;
    @ApiModelProperty("学生ID")
    private Long studentId;
    @ApiModelProperty("步数")
    private Integer stepNum;
    @ApiModelProperty("是否结束")
    private Boolean isEnd;

    private StudentInfoDTO studentInfoDTO;

    private CourseInfoDTO courseInfoDTO;


}