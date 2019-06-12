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
public enum UsedStatusEnum implements BaseEnum {
    NOT_USED(0,"没有使用过"),

    USING(1,"正在使用"),

    ALREADY_USED(2,"已经使用"),
    ;
    private static Map<Integer, UsedStatusEnum> ELEMENTS_MAP;

    static {
        ELEMENTS_MAP = Arrays.stream(UsedStatusEnum.values())
                .collect(Collectors.toMap(UsedStatusEnum::getValue, (element) -> element));
    }

    private final Integer value;
    private final String message;

    UsedStatusEnum(Integer value, String message) {
        this.value = value;
        this.message = message;
    }

    public static UsedStatusEnum valueOf(int value) {
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

