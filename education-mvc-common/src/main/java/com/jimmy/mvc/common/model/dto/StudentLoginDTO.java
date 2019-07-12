package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @ClassName: LoginDTO
 * @Description:
 * @author: aiden
 * @date: 2019/7/8/008.
 */
@Data
@ApiModel("课程详细信息")
public class StudentLoginDTO {
    /**
     * 登录的密码
     */
    @NotBlank(message = "登录的密码不能为空")
    @ApiModelProperty("登录的密码")
    private String password;
    /**
     * 机床的ID
     */
    @NotNull(message = "机床的ID不能为空")
    @ApiModelProperty("机床的ID")
    private Long machinaId;

    /**
     * 登录的账号
     */
    @NotBlank(message = "登录的账号不能为空")
    @ApiModelProperty("登录的账号")
    private String userName;

}
