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
public enum AnswerTypeEnum implements BaseEnum {
    SELECT(0, "选择题"),
    QUESTION(1, "问答题"),
    BLUEPRINT_ANSWER(2, "图纸答案");
    private static Map<Integer, AnswerTypeEnum> ELEMENTS_MAP;

    static {
        ELEMENTS_MAP = Arrays.stream(AnswerTypeEnum.values())
                .collect(Collectors.toMap(AnswerTypeEnum::getValue, (element) -> element));
    }

    private final Integer value;
    private final String message;

    AnswerTypeEnum(Integer value, String message) {
        this.value = value;
        this.message = message;
    }

    public static AnswerTypeEnum valueOf(int value) {
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

