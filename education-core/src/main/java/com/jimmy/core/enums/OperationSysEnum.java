package com.jimmy.core.enums;


public enum OperationSysEnum {
    WEB_MANAGER(0, "管理系统"), TRECHER(1, "老师"), STUDENT(2, "学生");
    private final Integer code;
    private final String desc;

    private OperationSysEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }


    public String getDesc() {
        return desc;
    }


    public static OperationSysEnum getEnum(Byte code) {
        for (OperationSysEnum operation : OperationSysEnum.values()) {
            if (operation.getCode().equals(code)) {
                return operation;
            }
        }
        return null;
    }
}
