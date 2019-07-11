package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@Data
@ApiModel("������Ϣ")
public class MachineInfoDTO extends BaseDTO {
    /**
     * ����ID
     */
    @ApiModelProperty("����ID")
    private Long roomId;
    /**
     * ���
     */
    @ApiModelProperty("���")
    @NotBlank(message = "������Ų���Ϊ��")
    private String sn;
    /**
     * ����
     */
    @ApiModelProperty("����")
    @NotNull(message = "��������Ϊ��")
    private Integer rowNum;
    /**
     * ����
     */
    @ApiModelProperty("����")
    @NotNull(message = "��������Ϊ��")
    private Integer columnNum;


}