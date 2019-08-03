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
public enum ContentTypeEnum implements BaseEnum {
    IMG(0, "图片"),
    VIDEO(1, "视频"),
    TEXT(2, "文字"),
    BLUEPRINT(3, "图纸以及图纸答案"),
    QUESTION(5, "问答题"),
    RADIO(6, "单选题"),
    CHECK_BOX(7, "多选题"),;
    private static Map<Integer, ContentTypeEnum> ELEMENTS_MAP;

    static {
        ELEMENTS_MAP = Arrays.stream(ContentTypeEnum.values())
                .collect(Collectors.toMap(ContentTypeEnum::getValue, (element) -> element));
    }

    private final Integer value;
    private final String message;

    ContentTypeEnum(Integer value, String message) {
        this.value = value;
        this.message = message;
    }

    public static ContentTypeEnum valueOf(int value) {
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

