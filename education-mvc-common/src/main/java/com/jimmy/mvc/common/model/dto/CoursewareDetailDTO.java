package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.Api;
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
@Api("�μ���Ϣ")
public class CoursewareDetailDTO {
    @ApiModelProperty("�μ���ID")
    private Long courseId;
    @ApiModelProperty("�μ�����Ϣ")
    private CoursewareDTO courseware;
    @ApiModelProperty("�μ�����ϸ����")
    private List<CoursewareItemDTO> coursewareItemList;
}
