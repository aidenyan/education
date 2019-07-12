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
public class StudentLoginDTO {
    /**
     * ��¼������
     */
    @NotBlank(message = "��¼�����벻��Ϊ��")
    @ApiModelProperty("��¼������")
    private String password;
    /**
     * ������ID
     */
    @NotNull(message = "������ID����Ϊ��")
    @ApiModelProperty("������ID")
    private Long machinaId;

    /**
     * ��¼���˺�
     */
    @NotBlank(message = "��¼���˺Ų���Ϊ��")
    @ApiModelProperty("��¼���˺�")
    private String userName;

}
