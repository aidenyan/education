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
@ApiModel("�γ̿μ���ϵ")
public class CourseCoursewareDTO {
    /**
     * �γ�ID
     */
    @ApiModelProperty("�γ�ID")
    private Long courseId;
    /**
     * �μ�ID
     */
    @ApiModelProperty("�μ�ID")
    private List<Long> coursewareIdList;
}
