package com.jimmy.mvc.common.enums;

import com.jimmy.core.enums.ResultEnum;

/**
 * @author aiden
 * @date 2017/2/21
 */
public enum ResultCodeEnum implements ResultEnum {
    OK("0", "�ɹ�", "�ɹ�"),
    ACCOUNT_NOT_EXIST("-10001","�˺Ų�����","�˺Ų�����"),
    PASSWORD_ERROR("-10002","�������","�������"),
    ROOM_NOT_EXIST("-10003","���Ҳ�����","���Ҳ�����"),
    COURSE_NOT_EXIST("-10004","�ý���û�пγ�","�ý���û�пγ�"),
    STUDNE_ANSWER_NOT_EXIST("-10005","ѧ����û�лش�","�ý���û�пγ�"),
    MACHINE_STUDENT_NOT_EXIST("-10006","�û�����û��ѧ��","�û�����û��ѧ��"),
    APPRIASE_ALREADY_EXIST("-10007","�û����Ѿ����۹���","�û����Ѿ����۹���"),
    COURSE_NOT_START("-10008","��û�п�ʼ�Ͽ�","��û�п�ʼ�Ͽ�"),
    OLD_PASSWORD_ERROR("-10009","ԭ�������","ԭ�������"),


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
