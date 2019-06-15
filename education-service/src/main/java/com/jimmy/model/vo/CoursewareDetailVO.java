package com.jimmy.model.vo;

import com.jimmy.dao.entity.Courseware;
import com.jimmy.dao.entity.CoursewareItem;
import lombok.Data;

import java.util.List;

/**
 * @ClassName: CoursewareDetailVO
 * @Description:
 * @author: aiden
 * @date: 2019/6/12/012.
 */
@Data
public class CoursewareDetailVO {
    private Courseware courseware;

    private List<CoursewareItem> coursewareItemList;
}
