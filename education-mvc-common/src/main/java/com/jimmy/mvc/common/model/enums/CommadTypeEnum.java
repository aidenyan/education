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
public enum CommadTypeEnum implements BaseEnum {
    /**
     * 链接之后的第一条数据
     */
    INIT(0, "初始化"),
    SIGN_IN(1, "签到命令"),;
    private static Map<Integer, CommadTypeEnum> ELEMENTS_MAP;

    static {
        ELEMENTS_MAP = Arrays.stream(CommadTypeEnum.values())
                .collect(Collectors.toMap(CommadTypeEnum::getValue, (element) -> element));
    }

    private final Integer value;
    private final String message;


    CommadTypeEnum(Integer value, String message) {
        this.value = value;
        this.message = message;
    }

    public static CommadTypeEnum valueOf(int value) {
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

