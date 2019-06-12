package com.jimmy.mvc.common.enums;

import com.jimmy.core.enums.ResultEnum;

/**
 * @author aiden
 * @date 2017/2/21
 */
public enum ResultCodeEnum implements ResultEnum {
    OK("200", "成功", "成功"),
    ACCOUNT_NOT_EXIST("-10001","账号不存在","账号不存在"),
    PASSWORD_ERROR("-10002","密码错误","密码错误"),
    ROOM_NOT_EXIST("-10003","教室不成在","教室不成在"),
    COURSE_NOT_EXIST("-10004","该教室没有课程","该教室没有课程"),

    ;
    private String code;
    private String message;
    private String desc;

     ResultCodeEnum(String code, String message, String desc) {
        this.code = code;
        this.message = message;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
