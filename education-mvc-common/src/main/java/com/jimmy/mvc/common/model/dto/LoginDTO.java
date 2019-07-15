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
@ApiModel("�γ���ϸ��Ϣ")
public class LoginDTO {
    /**
     * ��¼������
     */
    @NotBlank(message = "��¼�����벻��Ϊ��", groups = {LoginDTO.Pad.class, LoginDTO.Teacher.class})
    @ApiModelProperty("��¼������")
    private String password;
    /**
     * �����ID
     */
    @NotNull(message = "�����ID����Ϊ��", groups = {LoginDTO.Teacher.class})
    @ApiModelProperty("�����ID")
    private Long roomId;

    /**
     * ��¼���˺�
     */
    @NotBlank(message = "��¼���˺Ų���Ϊ��", groups = {LoginDTO.Pad.class, LoginDTO.Teacher.class})
    @ApiModelProperty("��¼���˺�")
    private String userName;

    public interface Pad {
    }


    public interface Teacher {
    }
    public interface Student {
    }
}