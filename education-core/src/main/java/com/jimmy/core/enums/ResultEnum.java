package com.jimmy.core.enums;

/**
 * @author aiden
 * @date 2017/3/1
 */
public interface ResultEnum {
    public String getCode();

    public void setCode(String code);

    /**
     * ������ʾ��Ϣ
     *
     * @return
     */
    public String getMessage();

    public void setMessage(String message);

    /**
     * �쳣������Ϣ
     *
     * @return
     */
    public String getDesc();

    public void setDesc(String desc);
}
