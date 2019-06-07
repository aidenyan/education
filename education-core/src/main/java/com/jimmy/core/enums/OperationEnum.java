package com.jimmy.core.enums;


public enum OperationEnum {
    SAVE(1, "新增"), UPDATE(2, "更新"), DELETE(3, "删除"), DISABLE_ENABLE(4, "禁用/启用"),;
    private final Integer code;
    private final String desc;

    private OperationEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }


    public String getDesc() {
        return desc;
    }


    public static OperationEnum getEnum(Byte code) {
        for (OperationEnum operation : OperationEnum.values()) {
            if (operation.getCode().equals(code)) {
                return operation;
            }
        }
        return null;
    }
}
