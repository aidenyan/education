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
public enum CoursewareItemTypeEnum implements BaseEnum {
    RESOURCE(0, "×ÊÔ´"),
    QUESTION(1, "Ìâ¿â");
    private static Map<Integer, CoursewareItemTypeEnum> ELEMENTS_MAP;

    static {
        ELEMENTS_MAP = Arrays.stream(CoursewareItemTypeEnum.values())
                .collect(Collectors.toMap(CoursewareItemTypeEnum::getValue, (element) -> element));
    }

    private final Integer value;
    private final String message;

    CoursewareItemTypeEnum(Integer value, String message) {
        this.value = value;
        this.message = message;
    }

    public static CoursewareItemTypeEnum valueOf(int value) {
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

