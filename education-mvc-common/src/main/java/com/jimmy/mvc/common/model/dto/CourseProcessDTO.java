package com.jimmy.mvc.common.model.dto;

import com.jimmy.dao.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@ApiModel("�γ���Ϣ��Ϣ")
public class CourseProcessDTO  {

   @NotNull(message = "�μ���ϸ��ϢID����Ϊ��")
    @ApiModelProperty("�μ���ϸ��ϢID")
    private Long coursewareItemId;
    @NotBlank(message = "�μ���ϸ��Ϣ���ֲ���Ϊ��")
    @ApiModelProperty("�μ���ϸ��Ϣ����")
    private String coursewareItemName;
    @NotNull(message = "��������Ϊ��")
    @ApiModelProperty("����")
    private Integer stepNum;




}