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
public enum CommandTypeEnum implements BaseEnum {
    /**
     * 链接之后的第一条数据Broadcast text
     */
    INIT(0, "初始化", false),
    SIGN_IN(1, "签到命令", true),
    BROADCAST_TEXT(2, "广播文字信息", true),
    BROADCAST_VIDEO(3, "广播视频信息", true),
    INTERACTIVE(4, "交互", true),
    MIDDLE_SIGN_IN(5, "中途签到", true),
    RAISE_HAND(6,"举手",true),
    ASK_LEVEL(7,"请假",true),
    ASK_LEVEL_END(8,"请假结束",true),
    RAISE_HAND_END(9,"举手结束",true),
    UPDATE_PROCESS(11,"更新进程",true),
    ;
    private static Map<Integer, CommandTypeEnum> ELEMENTS_MAP;

    static {
        ELEMENTS_MAP = Arrays.stream(CommandTypeEnum.values())
                .collect(Collectors.toMap(CommandTypeEnum::getValue, (element) -> element));
    }

    private final Integer value;
    private final String message;
    private final boolean isSend;

    CommandTypeEnum(Integer value, String message, boolean isSend) {
        this.value = value;
        this.message = message;
        this.isSend = isSend;
    }

    public static CommandTypeEnum valueOf(int value) {
        return ELEMENTS_MAP.get(value);
    }

    @Override
    public int getValue() {
        return value;
    }

    public boolean isSend() {
        return isSend;
    }

    @Override
    public String getMessage() {
        return message;
    }

}

