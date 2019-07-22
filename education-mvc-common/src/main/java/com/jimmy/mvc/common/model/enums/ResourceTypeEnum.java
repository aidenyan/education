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
    IMG(0, "Í¼Æ¬"),
    VIDEO(1, "ÊÓÆµ"),
    TEXT(2, "ÎÄ×Ö"),
    BLUEPRINT(3, "Í¼Ö½"),
    BLUEPRINT_ANSWER(4, "Í¼Ö½µÄ´ð°¸");
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

