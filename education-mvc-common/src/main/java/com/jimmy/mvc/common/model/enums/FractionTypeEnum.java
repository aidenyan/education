package com.jimmy.mvc.common.model.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName: FractionTypeEnum
 * @Description:
 * @author: aiden
 * @date: 2019/6/11/011.
 */
public enum FractionTypeEnum implements BaseEnum {
    DICTIONARY(0, "字典的内容"),
    COURSEWARE_ITEM(1, "课件详细信息ID");
    private static Map<Integer, FractionTypeEnum> ELEMENTS_MAP;

    static {
        ELEMENTS_MAP = Arrays.stream(FractionTypeEnum.values())
                .collect(Collectors.toMap(FractionTypeEnum::getValue, (element) -> element));
    }

    private final Integer value;
    private final String message;

    FractionTypeEnum(Integer value, String message) {
        this.value = value;
        this.message = message;
    }

    public static FractionTypeEnum valueOf(int value) {
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

