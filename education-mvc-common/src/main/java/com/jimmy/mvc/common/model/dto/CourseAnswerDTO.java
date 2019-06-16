package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@ApiModel("课程的回答信息")
public class CourseAnswerDTO extends BaseDTO {

    /**
     * 课程ID
     */
    @ApiModelProperty("课程ID")
    private Long courseId;
    /**
     * 机床ID
     */
    @ApiModelProperty("机床ID")
    private Long machineId;
    /**
     * 课件ID
     */
    @ApiModelProperty("机床ID")
    private Long coursewareId;
    /**
     * 课件详细ID
     */
    @ApiModelProperty("课件详细ID")
    private Long coursewareItemId;
    /**
     * 分数
     */
    @ApiModelProperty("分数")
    private BigDecimal fraction;
    /**
     * 学生的回答
     */
    @ApiModelProperty("学生的回答")
    private List<AnswerDTO> studentResult;
    /**
     * 老师的回答
     */
    @ApiModelProperty("老师的回答")
    private List<AnswerDTO> tearchResult;

}