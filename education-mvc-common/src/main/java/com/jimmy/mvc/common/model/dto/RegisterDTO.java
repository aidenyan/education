package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@ApiModel("签到信息")
public class RegisterDTO {

    /**
     * 学生ID
     */
    @NotNull(message = "学生ID不能未空")
    @ApiModelProperty("学生ID")
    private Long studentId;
    /**
     * 课程ID
     */
    @NotNull(message = "课程ID不能未空")
    @ApiModelProperty("课程ID")
    private Long courseId;
    /**
     * 命令ID
     */
    @NotNull(message = "命令ID不能未空")
    @ApiModelProperty("命令ID")
    private Long commandId;




}