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
public enum LevelTypeEnum implements BaseEnum {
    LOW(0, "����"),
    MIDDLE(1, "�м�"),
    HEIGHT(2, "�߼�"),;
    private static Map<Integer, LevelTypeEnum> ELEMENTS_MAP;

    static {
        ELEMENTS_MAP = Arrays.stream(LevelTypeEnum.values())
                .collect(Collectors.toMap(LevelTypeEnum::getValue, (element) -> element));
    }

    private final Integer value;
    private final String message;

    LevelTypeEnum(Integer value, String message) {
        this.value = value;
        this.message = message;
    }

    public static LevelTypeEnum valueOf(int value) {
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

