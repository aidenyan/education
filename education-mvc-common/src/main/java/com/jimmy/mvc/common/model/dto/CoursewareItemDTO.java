package com.jimmy.mvc.common.model.dto;

import com.alibaba.fastjson.JSON;
import com.jimmy.common.utils.StringUtils;
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
    @ApiModelProperty("�μ�����")
    private CoursewareItemTypeEnum type;
    /**
     * ���typeΪ0��0��ͼƬ��1����Ƶ��2:���֣�3��ͼֽ�����δ1��5���ʴ��⣬6:��ѡ�⣬7.��ѡ��
     */
    @ApiModelProperty("0��ͼƬ��1����Ƶ��2:���֣�3�����ʴ��⣬6:��ѡ��ͼֽ;5��7.��ѡ��")
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

    @ApiModelProperty("ͼƬ��Ƶ��ַ")
    private String imgVideoText;

    

    public String getImgVideoText() {
        return imgVideoText;
    }

    public void setImgVideoText(String imgVideoText) {
        this.imgVideoText = imgVideoText;
    }

    public Object getContentObj() {
        if (StringUtils.isBlank(content)) {
            return null;
        }
        if (ContentTypeEnum.BLUEPRINT == getContentType()) {
            contentObj = JSON.parseObject(content, DrawingDTO.class);
        }
        return contentObj;
    }

    public void setContentObj(Object contentObj) {
        this.contentObj = contentObj;
        if (contentObj != null) {
            content = JSON.toJSONString(contentObj);
        }
    }

    public <T> T convert(Class<T> tClass) {
        if (StringUtils.isBlank(content)) {
            return null;
        }

        return JSON.parseObject(content, tClass);
    }

}