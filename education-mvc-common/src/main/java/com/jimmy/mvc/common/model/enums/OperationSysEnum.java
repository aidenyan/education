package com.jimmy.mvc.common.model.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName: StaffTypeEnum
 * @Description:
 * @author: aiden
 * @date: 2019/6/11/011.
 */
public enum OperationSysEnum implements BaseEnum {
    TEACHER(0, "��ʦϵͳ"),
    STUDENT(1, "ѧ��ϵͳ"),
    TEACHER_PAD(2, "��ʦPADϵͳ"),
    WEB(3, "����ϵͳ"),;
    ;
    private static Map<Integer, OperationSysEnum> ELEMENTS_MAP;

    static {
        ELEMENTS_MAP = Arrays.stream(OperationSysEnum.values())
                .collect(Collectors.toMap(OperationSysEnum::getValue, (element) -> element));
    }

    private final Integer value;
    private final String message;

    OperationSysEnum(Integer value, String message) {
        this.value = value;
        this.message = message;
    }

    public static OperationSysEnum valueOf(int value) {
        return ELEMENTS_MAP.get(value);
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public String getMessage(String message) {
        return message;
    }
}

