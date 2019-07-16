package com.jimmy.mvc.common.model.dto;

import com.jimmy.mvc.common.model.enums.UsedStatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@ApiModel("�γ���Ϣ")
public class CourseInfoDTO extends BaseDTO {

    /**
     * �γ̵�����
     */
    @ApiModelProperty("�γ̵�����")
    @NotBlank(message = "�γ̵��������ֲ���Ϊ��")
    private String name;
    /**
     * �γ̿�ʼʱ��
     */
    @ApiModelProperty("�γ̿�ʼʱ��")
    @NotNull(message = "�γ̿�ʼʱ�䲻��Ϊ��")
    private Date startTime;
    /**
     * �γ�ʱ�䳤��
     */
    @ApiModelProperty("�γ�ʱ�䳤��")
    @NotNull(message = "�γ�ʱ�䳤�Ȳ���Ϊ��")
    private Integer timeLong;
    /**
     * ����ID
     */
    @ApiModelProperty("����ID")
    @NotNull(message = "����ID����Ϊ��")
    private Long roomId;
    /**
     * ��ʦID
     */
    @ApiModelProperty("��ʦID")
    private Long teacherId;
    /**
     * ʹ��״̬
     */
    @ApiModelProperty("ʹ��״̬")
    private UsedStatusEnum usedStatus;
    /**
     * ����
     */
    @ApiModelProperty("����")
    private String description;
    /**
     * ʹ�õ���ʦ
     */
    @ApiModelProperty("ʹ�õ���ʦ")
    private Long usedTeacherId;
}