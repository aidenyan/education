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
public enum SexEnum implements BaseEnum {
        MAN(1, "ÄÐ"),
    WOMAN(0, "Å®");
    private static Map<Integer, SexEnum> ELEMENTS_MAP;

    static {
        ELEMENTS_MAP = Arrays.stream(SexEnum.values())
                .collect(Collectors.toMap(SexEnum::getValue, (element) -> element));
    }

    private final Integer value;
    private final String message;

    SexEnum(Integer value, String message) {
        this.value = value;
        this.message = message;
    }

    public static SexEnum valueOf(int value) {
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

