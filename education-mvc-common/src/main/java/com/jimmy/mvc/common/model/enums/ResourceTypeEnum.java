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
public enum ResourceTypeEnum implements BaseEnum {
    IMG(0, "ͼƬ"),
    VIDEO(1, "��Ƶ"),
    TEXT(2, "����"),
    BLUEPRINT(3, "ͼֽ"),
    BLUEPRINT_ANSWER(4, "ͼֽ�Ĵ�");
    private static Map<Integer, ResourceTypeEnum> ELEMENTS_MAP;

    static {
        ELEMENTS_MAP = Arrays.stream(ResourceTypeEnum.values())
                .collect(Collectors.toMap(ResourceTypeEnum::getValue, (element) -> element));
    }

    private final Integer value;
    private final String message;

    ResourceTypeEnum(Integer value, String message) {
        this.value = value;
        this.message = message;
    }

    public static ResourceTypeEnum valueOf(int value) {
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

