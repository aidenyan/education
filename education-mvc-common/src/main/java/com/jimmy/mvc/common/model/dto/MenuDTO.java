package com.jimmy.mvc.common.model.dto;


import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel("≤Àµ•–≈œ¢")
public class MenuDTO extends BaseDTO {


    private String urlPath;

    private String code;

    private Integer menuType;

    private Short parentMenuId;

    private String name;

    private String menuUrl;

    private Integer menuLevel;

    private Short orderNum;

    private Boolean deleted;
}
