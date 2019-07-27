package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: TempClassmateSaveDTO
 * @Description:
 * @author: aiden
 * @date: 2019/7/11/011.
 */
@Data
@ApiModel("班级临时信息保存对象")
public class TempClassmateSaveDTO implements Serializable {

    private static final long serialVersionUID = -8873260055802642987L;
    @NotEmpty(message = "选定的班级不能为空")
    @ApiModelProperty("选定的班级")
    private List<Long> classMateIdList;
    @NotNull(message = "选定的课程不能为空")
    @ApiModelProperty("选定的课程")
    private Long courseId;
    @ApiModelProperty("临时班级的名称")
    private String name;
}
