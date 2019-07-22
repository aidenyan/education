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
public enum QuestionTypeEnum implements BaseEnum {
    QUESTION_AN_ANSWERS(0, "问答题"),
    SINGLE_CHOICE(1, "单选题"),
    MULTIPLE_CHOICE(2, "多选题"),;
    private static Map<Integer, QuestionTypeEnum> ELEMENTS_MAP;

    static {
        ELEMENTS_MAP = Arrays.stream(QuestionTypeEnum.values())
                .collect(Collectors.toMap(QuestionTypeEnum::getValue, (element) -> element));
    }

    private final Integer value;
    private final String message;

    QuestionTypeEnum(Integer value, String message) {
        this.value = value;
        this.message = message;
    }

    public static QuestionTypeEnum valueOf(int value) {
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

