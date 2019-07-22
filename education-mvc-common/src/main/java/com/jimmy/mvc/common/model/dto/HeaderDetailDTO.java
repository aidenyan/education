package com.jimmy.mvc.common.model.dto;

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
@ApiModel("头部详细信息")
public class HeaderDetailDTO implements Serializable {
    private static final long serialVersionUID = 4125013116058034535L;
    @ApiModelProperty("头部图片信息")
    @NotBlank(message = "头部图片信息不能为空")
    private String header;
    @ApiModelProperty("对应的学生/老师ID")
    @NotNull(message = "对应的学生/老师IDID不能为空")
    private Long userId;
    @ApiModelProperty("头部特征信息")
    @NotBlank(message = "头部特征信息不能为空")
    private String headerImg;
    @ApiModelProperty("头部特征信息版本")
    @NotBlank(message = "头部特征信息版本不能为空")
    private String faceVersion;


}
