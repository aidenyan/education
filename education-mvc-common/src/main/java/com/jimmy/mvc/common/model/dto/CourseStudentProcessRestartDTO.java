package com.jimmy.mvc.common.model.dto;

import com.jimmy.dao.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("����������Ϣ")
public class CourseStudentProcessRestartDTO extends BaseEntity {

    @ApiModelProperty("�γ�ID")
    private Long courseId;
    @ApiModelProperty("����ID")
    private Long machineId;
    @ApiModelProperty("�μ�ID")
    private Long coursewareId;
    @ApiModelProperty("�μ���ϸID")
    private Long coursewareItemId;
    @ApiModelProperty("�μ���ϸ����")
    private String coursewareItemName;
    @ApiModelProperty("����ʱ��")
    private Date updateTime;
    @ApiModelProperty("ѧ��ID")
    private Long studentId;
    @ApiModelProperty("����")
    private Integer stepNum;
    @ApiModelProperty("�Ƿ����")
    private Boolean isEnd;


}