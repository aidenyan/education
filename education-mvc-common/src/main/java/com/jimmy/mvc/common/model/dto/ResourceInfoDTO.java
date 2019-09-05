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
    private ResoureceStrDTO imgWordText;
    @ApiModelProperty("video��Ϣ")
    private VideoDTO videoDTO;
    @ApiModelProperty("ͼֽ��Ϣ")
    private BlueprintDTO blueprintDTO;


    public BlueprintDTO getBlueprintDTO() {
        if (ResourceTypeEnum.BLUEPRINT == type) {
            blueprintDTO = JSON.parseObject(content, BlueprintDTO.class);
            blueprintDTO.setTitle(title);
        }
        return blueprintDTO;
    }

    public void setBlueprintDTO(BlueprintDTO blueprintDTO) {
        if (ResourceTypeEnum.BLUEPRINT == type) {
            blueprintDTO.setTitle(null);
            content = JSON.toJSONString(blueprintDTO);
        }
    }


    public VideoDTO getVideoDTO() {
        if (ResourceTypeEnum.VIDEO == type) {
            videoDTO = JSON.parseObject(content, VideoDTO.class);
            videoDTO.setTitle(title);
        }
        return videoDTO;
    }

    public void setVideoDTO(VideoDTO videoDTO) {
        if (ResourceTypeEnum.VIDEO == type) {
            videoDTO.setTitle(null);
            content = JSON.toJSONString(videoDTO);
        }

    }

    public ResoureceStrDTO getImgWordText() {
        if (ResourceTypeEnum.TEXT == type || ResourceTypeEnum.IMG == type || ResourceTypeEnum.WORD == type) {
            imgWordText = new ResoureceStrDTO();
            imgWordText.setContent(content);
            imgWordText.setTitle(title);
        }
        return imgWordText;

    }

    public void setImgWordText(ResoureceStrDTO imgWordText) {
        if (ResourceTypeEnum.TEXT == type || ResourceTypeEnum.IMG == type || ResourceTypeEnum.WORD == type) {
            content = imgWordText.getContent();
        }
    }


    public void setContent(String content) {
        if (StringUtils.isNotBlank(content)) {
            this.content = content;
        }
    }
}