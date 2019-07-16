package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @ClassName: InteractiveDTO
 * @Description:
 * @author: aiden
 * @date: 2019/6/19/019.
 */
@Data
@ApiModel("������Ϣ")
public class InteractiveDTO {
    @NotNull(message = "�����Ļ���ID����Ϊ��")
    @ApiModelProperty("�����Ļ���ID")
    private Long machineId;
    @NotBlank(message = "�����Ļ���������Ϣ����Ϊ��")
    @ApiModelProperty("����ʱ��Ҫ��������Ϣ")
    private String interactive;
}
