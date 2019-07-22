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
public enum StaffTypeEnum implements BaseEnum {
    TEACHER(1,"老师"),SCHOOL_MASTER(0,"校长");
    private static Map<Integer, StaffTypeEnum> ELEMENTS_MAP;

    static {
        ELEMENTS_MAP = Arrays.stream(StaffTypeEnum.values())
                .collect(Collectors.toMap(StaffTypeEnum::getValue, (element) -> element));
    }

    private final Integer value;
    private final String message;

    StaffTypeEnum(Integer value, String message) {
        this.value = value;
        this.message = message;
    }

    public static StaffTypeEnum valueOf(int value) {
        return ELEMENTS_MAP.get(value);
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

