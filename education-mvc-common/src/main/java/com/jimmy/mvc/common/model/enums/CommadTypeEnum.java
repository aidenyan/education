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
     * ����֮��ĵ�һ������
     */
    INIT(0, "��ʼ��"),
    SIGN_IN(1, "ǩ������"),;
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

