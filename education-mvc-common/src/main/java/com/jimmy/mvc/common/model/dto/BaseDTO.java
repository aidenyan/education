package com.jimmy.mvc.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("基本信息")
public class BaseDTO {
    /**
     * ID
     */
    @ApiModelProperty("ID")
    private Long id;
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createTime;
    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    private Date modifyTime;
    /**
     * 创建人
     */
    @ApiModelProperty("创建人")
    private Long createId;
    /**
     * 修改人
     */
    @ApiModelProperty("修改人")
    private Long modifyId;
    /**
     * 站点
     */
    @ApiModelProperty("站点")
    private Long siteId;
}
