package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @ClassName: CourseCoursewareDTO
 * @Description:
 * @author: aiden
 * @date: 2019/6/16/016.
 */
@Data
@ApiModel("课程课件关系")
public class CourseCoursewareDTO {
    /**
     * 课程ID
     */
    @ApiModelProperty("课程ID")
    private Long courseId;
    /**
     * 课件ID
     */
    @ApiModelProperty("课件ID")
    private List<Long> coursewareIdList;
}
