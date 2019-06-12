package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("教室信息")
public class ClassRoomDTO extends BaseDTO {
    /**
     * 教室编号
     */
    @ApiModelProperty("教室编号")
    private String sn;
    /**
     * 教室名字
     */
    @ApiModelProperty("教室名字")
    private String name;
    /**
     * 教室具体地址
     */
    @ApiModelProperty("教室具体地址")
    private String address;
    /**
     * 是否已经删除
     */
    @ApiModelProperty("是否已经删除")
    private Boolean isDeleted;
    /**
     * 描述
     */
    @ApiModelProperty("描述")
    private String description;


}