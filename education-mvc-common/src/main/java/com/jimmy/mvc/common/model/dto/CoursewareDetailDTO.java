package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @ClassName: CoursewareDetailVO
 * @Description:
 * @author: aiden
 * @date: 2019/6/12/012.
 */
@Data
public class CoursewareDetailDTO {
    @ApiModelProperty("课件的ID")
    private Long courseId;
    @ApiModelProperty("课件的信息")
    private CoursewareDTO courseware;
    @ApiModelProperty("课件的详细内容")
    private List<CoursewareItemDTO> coursewareItemList;
}
