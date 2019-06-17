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
public enum DirectionEnum implements BaseEnum {
    /**
     * ����֮��ĵ�һ������
     */
    TO_STUDENT(0, "��ʦ����ѧ��"),
    TO_TEACHER(1, "ѧ��������ʦ"),;
    private static Map<Integer, DirectionEnum> ELEMENTS_MAP;

    static {
        ELEMENTS_MAP = Arrays.stream(DirectionEnum.values())
                .collect(Collectors.toMap(DirectionEnum::getValue, (element) -> element));
    }

    private final Integer value;
    private final String message;


    DirectionEnum(Integer value, String message) {
        this.value = value;
        this.message = message;
    }

    public static DirectionEnum valueOf(int value) {
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

