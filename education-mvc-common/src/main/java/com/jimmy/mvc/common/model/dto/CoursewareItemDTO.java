package com.jimmy.mvc.common.model.dto;

import com.alibaba.fastjson.JSON;
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

    @ApiModelProperty("ͼƬword�ĵ��Լ��ı�")
    private String imgWordText;
    @ApiModelProperty("video��Ϣ")
    private VideoDTO videoDTO;
    @ApiModelProperty("ͼֽ����ϸ��Ϣ")
    private BlueprintDetailDTO blueprintDetailDTO;
    @ApiModelProperty("�������ϸ")
    private QuestionDTO questionDTO;

    public QuestionDTO getQuestionDTO() {
        if (ContentTypeEnum.QUESTION == contentType || ContentTypeEnum.RADIO == contentType || ContentTypeEnum.CHECK_BOX == contentType) {
            questionDTO = JSON.parseObject(content, QuestionDTO.class);
        }
        return questionDTO;
    }

    public void setQuestionDTO(QuestionDTO questionDTO) {
        if (ContentTypeEnum.QUESTION == contentType || ContentTypeEnum.RADIO == contentType || ContentTypeEnum.CHECK_BOX == contentType) {
            content = JSON.toJSONString(questionDTO);
        }
    }

    public BlueprintDetailDTO getBlueprintDetailDTO() {
        if (ContentTypeEnum.BLUEPRINT == contentType) {
            blueprintDetailDTO = JSON.parseObject(content, BlueprintDetailDTO.class);
        }
        return blueprintDetailDTO;
    }

    public void setBlueprintDetailDTO(BlueprintDetailDTO blueprintDetailDTO) {
        if (ContentTypeEnum.BLUEPRINT == contentType) {
            content = JSON.toJSONString(blueprintDetailDTO);
        }
    }

    public VideoDTO getVideoDTO() {
        if (ContentTypeEnum.VIDEO == contentType) {
            videoDTO = JSON.parseObject(content, VideoDTO.class);
        }
        return videoDTO;
    }

    public void setVideoDTO(VideoDTO videoDTO) {
        if (ContentTypeEnum.VIDEO == contentType) {
            content = JSON.toJSONString(videoDTO);
        }

    }

    public String getImgWordText() {
        if (ContentTypeEnum.TEXT == contentType || ContentTypeEnum.IMG == contentType || ContentTypeEnum.WORD == contentType) {
            imgWordText = content;
        }
        return imgWordText;

    }

    public void setImgWordText(String imgWordText) {
        if (ContentTypeEnum.TEXT == contentType || ContentTypeEnum.IMG == contentType || ContentTypeEnum.WORD == contentType) {
            content = imgWordText;
        }
    }

    public void setContent(String content) {

    }
}