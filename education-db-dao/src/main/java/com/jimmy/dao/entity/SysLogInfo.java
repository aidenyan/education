package com.jimmy.dao.entity;

import lombok.Data;


@Data
public class SysLogInfo extends BaseEntity{

    private Integer operationSys;

    private Long operationId;

    private String operationName;

    private String operationContent;

    private String operationCode;

    private String operationIp;

    private Integer logType;

    private String objId;

    private String sign;

    private Integer objType;

    private String operationResult;

    private String operationDetail;

    private String operationUuid;


}