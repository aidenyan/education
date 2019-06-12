package com.jimmy.mvc.common.model.dto;

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
    private CoursewareDTO courseware;

    private List<CoursewareItemDTO> coursewareItemList;
}
