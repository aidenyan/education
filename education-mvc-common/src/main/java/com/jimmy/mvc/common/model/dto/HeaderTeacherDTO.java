package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
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
@ApiModel("老师头部特征信息")
public class HeaderTeacherDTO implements Serializable {
    private static final long serialVersionUID = 4125013116058034535L;
    @ApiModelProperty("头部信息")
    @NotBlank(message = "头部信息不能为空")
    private String header;
    @ApiModelProperty("头部特征信息")
    @NotBlank(message = "头部特征信息不能为空")
    private String headerImg;
    @ApiModelProperty("头部特征信息版本")
    @NotNull(message = "头部特征信息版本不能为空")
    private Integer faceVersion;

}
