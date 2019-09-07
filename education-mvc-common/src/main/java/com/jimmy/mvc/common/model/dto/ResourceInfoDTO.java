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
@ApiModel("资源信息")
public class ResourceInfoDTO extends BaseDTO {
    @NotNull(message = "资源类型不能未空")
    @ApiModelProperty("资源类型")
    private ResourceTypeEnum type;
    @ApiModelProperty("是否删除")
    private Boolean isDeleted;
    @NotBlank(message = "资源内容不能未空")
    @ApiModelProperty("资源内容")
    private String content;
    @ApiModelProperty("资源内容对象")
    private Object contentObj;
    @ApiModelProperty("资源标题")
    private String title;

    @ApiModelProperty("图片word文档以及文本")
    private ResoureceStrDTO imgWordText;
    @ApiModelProperty("video信息")
    private VideoDTO videoDTO;
    @ApiModelProperty("图纸信息")
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