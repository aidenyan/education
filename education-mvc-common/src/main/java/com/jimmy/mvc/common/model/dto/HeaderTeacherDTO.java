package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @ClassName: HeaderDTO
 * @Description:
 * @author: aiden
 * @date: 2019/7/12/012.
 */
@Data
@ApiModel("��ʦͷ��������Ϣ")
public class HeaderTeacherDTO implements Serializable {
    private static final long serialVersionUID = 4125013116058034535L;
    @ApiModelProperty("ͷ����Ϣ")
    @NotBlank(message = "ͷ����Ϣ����Ϊ��")
    private String header;
    @ApiModelProperty("ͷ��������Ϣ")
    @NotBlank(message = "ͷ��������Ϣ����Ϊ��")
    private String headerImg;
}
