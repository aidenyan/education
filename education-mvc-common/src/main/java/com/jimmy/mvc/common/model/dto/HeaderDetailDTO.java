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
@ApiModel("ͷ����ϸ��Ϣ")
public class HeaderDetailDTO implements Serializable {
    private static final long serialVersionUID = 4125013116058034535L;
    @ApiModelProperty("ͷ��ͼƬ��Ϣ")
    @NotBlank(message = "ͷ��ͼƬ��Ϣ����Ϊ��")
    private String header;
    @ApiModelProperty("��Ӧ��ѧ��/��ʦID")
    @NotNull(message = "��Ӧ��ѧ��/��ʦIDID����Ϊ��")
    private Long userId;
    @ApiModelProperty("ͷ��������Ϣ")
    @NotBlank(message = "ͷ��������Ϣ����Ϊ��")
    private String headerImg;
    @ApiModelProperty("ͷ��������Ϣ�汾")
    @NotBlank(message = "ͷ��������Ϣ�汾����Ϊ��")
    private String faceVersion;


}
