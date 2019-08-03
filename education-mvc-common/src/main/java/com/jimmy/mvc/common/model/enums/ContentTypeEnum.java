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
    IMG(0, "ͼƬ"),
    VIDEO(1, "��Ƶ"),
    TEXT(2, "����"),
    BLUEPRINT(3, "ͼֽ�Լ�ͼֽ��"),
    QUESTION(5, "�ʴ���"),
    RADIO(6, "��ѡ��"),
    CHECK_BOX(7, "��ѡ��"),;
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

