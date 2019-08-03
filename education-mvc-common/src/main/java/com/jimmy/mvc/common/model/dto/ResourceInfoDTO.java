package com.jimmy.mvc.common.model.dto;

import com.alibaba.fastjson.JSON;
import com.jimmy.common.utils.StringUtils;
import com.jimmy.mvc.common.model.enums.ResourceTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@Data
@ApiModel("��Դ��Ϣ")
public class ResourceInfoDTO extends BaseDTO {
    @NotNull(message = "��Դ���Ͳ���δ��")
    @ApiModelProperty("��Դ����")
    private ResourceTypeEnum type;
    @ApiModelProperty("�Ƿ�ɾ��")
    private Boolean isDeleted;
    @NotBlank(message = "��Դ���ݲ���δ��")
    @ApiModelProperty("��Դ����")
    private String content;
    @ApiModelProperty("��Դ���ݶ���")
    private Object contentObj;
    @ApiModelProperty("��Դ����")
    private String title;

    @ApiModelProperty("ͼƬword�ĵ��Լ��ı�")
    private String imgWordText;
    @ApiModelProperty("video��Ϣ")
    private VideoDTO videoDTO;
    @ApiModelProperty("ͼֽ��Ϣ")
    private BlueprintDTO blueprintDTO;
    @ApiModelProperty("ͼֽ����Ϣ")
    private BlueprintAnswerDTO blueprintAnswerDTO;

    public BlueprintDTO getBlueprintDTO() {
        if (ResourceTypeEnum.BLUEPRINT == type) {
            blueprintDTO = JSON.parseObject(content, BlueprintDTO.class);
        }
        return blueprintDTO;
    }

    public void setBlueprintDTO(BlueprintDTO blueprintDTO) {
        if (ResourceTypeEnum.BLUEPRINT == type) {
            content = JSON.toJSONString(blueprintDTO);
        }
    }

    public BlueprintAnswerDTO getBlueprintAnswerDTO() {
        if (ResourceTypeEnum.BLUEPRINT_ANSWER == type) {
            blueprintAnswerDTO = JSON.parseObject(content, BlueprintAnswerDTO.class);
        }
        return blueprintAnswerDTO;
    }

    public void setBlueprintAnswerDTO(BlueprintAnswerDTO blueprintAnswerDTO) {
        if (ResourceTypeEnum.BLUEPRINT_ANSWER == type) {
            content = JSON.toJSONString(blueprintAnswerDTO);
        }
    }

    public VideoDTO getVideoDTO() {
        if (ResourceTypeEnum.VIDEO == type) {
            videoDTO = JSON.parseObject(content, VideoDTO.class);
        }
        return videoDTO;
    }

    public void setVideoDTO(VideoDTO videoDTO) {
        if (ResourceTypeEnum.VIDEO == type) {
            content = JSON.toJSONString(videoDTO);
        }

    }

    public String getImgWordText() {
        if (ResourceTypeEnum.TEXT == type || ResourceTypeEnum.IMG == type || ResourceTypeEnum.WORD == type) {
            imgWordText = content;
        }
        return imgWordText;

    }

    public void setImgWordText(String imgWordText) {
        if (ResourceTypeEnum.TEXT == type || ResourceTypeEnum.IMG == type || ResourceTypeEnum.WORD == type) {
            content = imgWordText;
        }
    }


    public void setContent(String content) {
        if (StringUtils.isNotBlank(content)) {
            this.content = content;
        }
    }
}