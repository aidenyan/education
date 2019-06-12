package com.jimmy.mvc.common.model.dto;

import com.jimmy.mvc.common.model.enums.ContentTypeEnum;
import com.jimmy.mvc.common.model.enums.CoursewareItemTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("�γ���ϸ��Ϣ")
public class CoursewareItemDTO extends BaseDTO {

    /**
     * �μ����ͣ�0:��Դ��1:���
     */
    private CoursewareItemTypeEnum type;
    /**
     * ���typeΪ0��0��ͼƬ��1����Ƶ��2:���֣�3��ͼֽ�����δ1��5���ʴ��⣬6:��ѡ�⣬7.��ѡ��
     */
    @ApiModelProperty("0��ͼƬ��1����Ƶ��2:���֣�3��ͼֽ;5���ʴ��⣬6:��ѡ�⣬7.��ѡ��")
    private ContentTypeEnum contentType;
    /**
     * ���typeΪ0��Ϊ��ԴID,Ϊ1��Ϊ���ID
     */
    @ApiModelProperty("���typeΪ0��Ϊ��ԴID,Ϊ1��Ϊ���ID")
    private Long resourceId;
    /**
     * ���ݶ���Ϊ�������ݵ�һ��JSON����
     */
    @ApiModelProperty("���ݶ���Ϊ�������ݵ�һ��JSON����")
    private String content;
    @ApiModelProperty("������Ϣ����")
    private Object contentObj;
    /**
     * ����
     */
    @ApiModelProperty("����")
    private Integer orderNum;
    /**
     * �μ�ID
     */
    @ApiModelProperty("�μ�ID")
    private Long coursewareId;


}