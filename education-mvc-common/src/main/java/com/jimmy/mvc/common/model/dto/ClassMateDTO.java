package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @ClassName: ClassMateDTO
 * @Description:
 * @author: aiden
 * @date: 2019/7/9/009.
 */
@Data
@ApiModel("�༶��Ϣ")
public class ClassMateDTO extends BaseDTO {
    @NotBlank(message = "�༶����Ϊ��")
    @ApiModelProperty("�༶����")
    private String name;
    @ApiModelProperty("�༶����")
    private String description;
    @ApiModelProperty("�༶���")
    private String sn;
    @ApiModelProperty("�Ƿ�ɾ��")
    private Boolean isDeleted;
}
