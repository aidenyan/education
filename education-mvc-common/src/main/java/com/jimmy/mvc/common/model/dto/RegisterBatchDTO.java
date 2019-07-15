package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@ApiModel("ǩ����Ϣ")
public class RegisterBatchDTO {

    /**
     * ѧ��ID
     */
    @NotEmpty(message = "ѧ��ID����δ��")
    @ApiModelProperty("ѧ��ID")
    private List<Long> studentIdList;
    /**
     * �γ�ID
     */
    @NotNull(message = "�γ�ID����δ��")
    @ApiModelProperty("�γ�ID")
    private Long courseId;
    /**
     * ����ID
     */
    @NotNull(message = "����ID����δ��")
    @ApiModelProperty("����ID")
    private Long commandId;




}