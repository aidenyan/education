package com.jimmy.mvc.common.model.dto;

import com.jimmy.dao.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("课程信息")
public class CourseInfoDTO extends BaseDTO {

    /**
     * 课程的名字
     */
    @ApiModelProperty("课程的名字")
    private String name;
    /**
     * 课程开始时间
     */
    @ApiModelProperty("课程开始时间")
    private Date startTime;
    /**
     * 课程时间长度
     */
    @ApiModelProperty("课程时间长度")
    private Integer timeLong;
    /**
     * 教室ID
     */
    @ApiModelProperty("教室ID")
    private Long roomId;
    /**
     * 教师ID
     */
    @ApiModelProperty("教师ID")
    private Long teacherId;
    /**
     * 是否已经使用
     */
    @ApiModelProperty("是否已经使用")
    private Boolean isUsed;
    /**
     * 描述
     */
    @ApiModelProperty("描述")
    private String description;

}