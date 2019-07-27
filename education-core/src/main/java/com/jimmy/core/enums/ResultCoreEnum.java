package com.jimmy.core.enums;

/**
 * @author aiden
 * @date 2017/2/21
 */
public enum ResultCoreEnum implements ResultEnum {
    RESULT_EXCEPTION_SYS("-10001", "ϵͳ�쳣","ϵͳ�쳣"),
    RESULT_AUTHORITY_NOT_ENOUGH("-10002", "Ȩ�޲���","Ȩ�޲���"),
    RESULT_PARAMETER_EXCEPTION("-10003", "�����쳣","�����쳣"),
    RESULT_AUTHORITY_NOT_LOGIN("-10004","�û�δ��¼���¼ʧЧ","�û�δ��¼���¼ʧЧ"),
    RESULT_NOT_COURSE("-10005","�γ�û�п�ʼ","�γ�û�п�ʼ")

    ;
    private String code;
    private String message;
    private String desc;

    private ResultCoreEnum(String code, String message,String desc) {
        this.code = code;
        this.message = message;
        this.desc=desc;
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
