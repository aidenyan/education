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
    private String imgWordText;
    @ApiModelProperty("video信息")
    private VideoDTO videoDTO;
    @ApiModelProperty("图纸信息")
    private BlueprintDTO blueprintDTO;
    @ApiModelProperty("图纸答案信息")
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