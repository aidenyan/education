package com.jimmy.core.enums;


public enum ObjTypeEnum {
    ACCOUNT( 1, "帐号"), PRODUCT( 2, "老师"), INVENTORY( 3, "学生");

    private final Integer code;
    private final String desc;

    private ObjTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }


    public String getDesc() {
        return desc;
    }


    public static ObjTypeEnum getEnum(Byte code) {
        for (ObjTypeEnum objType : ObjTypeEnum.values()) {
            if (objType.getCode().equals(code)) {
                return objType;
            }
        }
        return null;
    }

}
