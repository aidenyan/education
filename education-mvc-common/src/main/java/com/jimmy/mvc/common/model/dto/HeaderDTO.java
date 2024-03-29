package com.jimmy.mvc.common.model.dto;

import com.jimmy.dao.entity.StudentInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @ClassName: HeaderDTO
 * @Description:
 * @author: aiden
 * @date: 2019/7/12/012.
 */
@Data
@ApiModel("头部特征信息")
public class HeaderDTO implements Serializable {
    private static final long serialVersionUID = 4125013116058034535L;
    @ApiModelProperty("头部信息")
    @NotBlank(message = "头部信息不能为空",groups = {Teacher.class, Student.class})
    private String header;
    @ApiModelProperty("对应的学生/老师ID")
    @NotNull(message = "对应的学生/老师IDID不能为空",groups = {Student.class})
    private Long userId;

    public interface Teacher{}
    public interface Student{}
}
