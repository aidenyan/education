package com.jimmy.mvc.common.model.dto;

import com.alibaba.fastjson.JSON;
import com.jimmy.mvc.common.model.enums.ContentTypeEnum;
import com.jimmy.mvc.common.model.enums.CoursewareItemTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("课程详细信息")
public class CoursewareItemDTO extends BaseDTO {

    /**
     * 课件类型，0:资源，1:题库
     */
    @ApiModelProperty("课件类型")
    private CoursewareItemTypeEnum type;
    /**
     * 如果type为0，0：图片，1：视频，2:文字；3：图纸；如果未1：5：问答题，6:单选题，7.多选题
     */
    @ApiModelProperty("0：图片，1：视频，2:文字；3：：问答题，6:单选题图纸;5，7.多选题")
    private ContentTypeEnum contentType;
    /**
     * 如果type为0则为资源ID,为1则为题库ID
     */
    @ApiModelProperty("如果type为0则为资源ID,为1则为题库ID")
    private Long resourceId;
    /**
     * 内容对象为具体内容的一个JSON对象
     */
    @ApiModelProperty("内容对象为具体内容的一个JSON对象")
    private String content;

    /**
     * 排序
     */
    @ApiModelProperty("排序")
    private Integer orderNum;
    /**
     * 课件ID
     */
    @ApiModelProperty("课件ID")
    private Long coursewareId;

    @ApiModelProperty("图片word文档以及文本")
    private String imgWordText;
    @ApiModelProperty("video信息")
    private VideoDTO videoDTO;
    @ApiModelProperty("图纸的详细信息")
    private BlueprintDetailDTO blueprintDetailDTO;
    @ApiModelProperty("问题的详细")
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