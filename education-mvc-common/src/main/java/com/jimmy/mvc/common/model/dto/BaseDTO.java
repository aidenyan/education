package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("������Ϣ")
public class BaseDTO {
    /**
     * ID
     */
    @ApiModelProperty("ID")
    private Long id;
    /**
     * ����ʱ��
     */
    @ApiModelProperty("����ʱ��")
    private Date createTime;
    /**
     * �޸�ʱ��
     */
    @ApiModelProperty("�޸�ʱ��")
    private Date modifyTime;
    /**
     * ������
     */
    @ApiModelProperty("������")
    private Long createId;
    /**
     * �޸���
     */
    @ApiModelProperty("�޸���")
    private Long modifyId;
    /**
     * վ��
     */
    @ApiModelProperty("վ��")
    private Long siteId;
}
