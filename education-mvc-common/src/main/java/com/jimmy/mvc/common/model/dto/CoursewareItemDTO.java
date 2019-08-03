package com.jimmy.mvc.common.model.dto;

import com.alibaba.fastjson.JSON;
import com.jimmy.common.utils.StringUtils;
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

    @ApiModelProperty("具体信息对像")
    private Object contentObj;
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

    @ApiModelProperty("图片视频地址")
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