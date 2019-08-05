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
public enum CourseStatusEnum implements BaseEnum {
    ASSIGN(0, "初始化分布"),
    USING(1, "使用中"),
    END(2, "结束");
    private static Map<Integer, CourseStatusEnum> ELEMENTS_MAP;

    static {
        ELEMENTS_MAP = Arrays.stream(CourseStatusEnum.values())
                .collect(Collectors.toMap(CourseStatusEnum::getValue, (element) -> element));
    }

    private final Integer value;
    private final String message;

    CourseStatusEnum(Integer value, String message) {
        this.value = value;
        this.message = message;
    }

    public static CourseStatusEnum valueOf(int value) {
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

