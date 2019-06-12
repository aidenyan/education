package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

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
    private String sn;
    /**
     * ����
     */
    @ApiModelProperty("����")
    private Integer rowNum;
    /**
     * ����
     */
    @ApiModelProperty("����")
    private Integer columnNum;


}