package com.jimmy.mvc.common.model.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName: ReceiveTypeEnum
 * @Description:
 * @author: aiden
 * @date: 2019/6/17/017.
 */
public enum ReceiveTypeEnum implements BaseEnum {
    ALL(0, "所有人"),
    USE_LIST(1, "用户列表");
    private static Map<Integer, ResourceTypeEnum> ELEMENTS_MAP;

    static {
        ELEMENTS_MAP = Arrays.stream(ResourceTypeEnum.values())
                .collect(Collectors.toMap(ResourceTypeEnum::getValue, (element) -> element));
    }

    private final Integer value;
    private final String message;

    ReceiveTypeEnum(Integer value, String message) {
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
