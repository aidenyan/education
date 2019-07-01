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
public enum LogTypeEnum implements BaseEnum {
    SYS(0, "±£´æ"),
    DELETED(1, "É¾³ý"),
    UPDATE(2, "¸üÐÂ"),;
    private static Map<Integer, LogTypeEnum> ELEMENTS_MAP;

    static {
        ELEMENTS_MAP = Arrays.stream(LogTypeEnum.values())
                .collect(Collectors.toMap(LogTypeEnum::getValue, (element) -> element));
    }

    private final Integer value;
    private final String message;

    LogTypeEnum(Integer value, String message) {
        this.value = value;
        this.message = message;
    }

    public static LogTypeEnum valueOf(int value) {
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

