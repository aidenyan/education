package com.jimmy.mvc.common.enums;

import com.jimmy.core.enums.ResultEnum;

/**
 * @author aiden
 * @date 2017/2/21
 */
public enum ResultCodeEnum implements ResultEnum {
    OK("0", "成功", "成功"),
    ACCOUNT_NOT_EXIST("-10001", "账号不存在", "账号不存在"),
    PASSWORD_ERROR("-10002", "密码错误", "密码错误"),
    ROOM_NOT_EXIST("-10003", "教室不成在", "教室不成在"),
    COURSE_NOT_EXIST("-10017", "该教室没有课程", "该教室没有课程"),
    STUDNE_ANSWER_NOT_EXIST("-10018", "学生还没有回答", "该教室没有课程"),
    MACHINE_STUDENT_NOT_EXIST("-10006", "该机床上没有学生", "该机床上没有学生"),
    APPRIASE_ALREADY_EXIST("-10007", "该机床已经评价过了", "该机床已经评价过了"),
    COURSE_NOT_START("-10008", "还没有开始上课", "还没有开始上课"),
    OLD_PASSWORD_ERROR("-10009", "原密码错误", "原密码错误"),


    QUESTION_RESULT_IS_BLANK("-10010", "问答题的回答不能为空", "问答题的回答不能为空"),

    QUESTION_ITEM_IS_EMPTY("-10011", "选择题的选项不能空", "选择题的选项不能空"),
    QUESTION_ITEM_ANSWER_EMPTY("-10012", "选择题的答案不能没有", "选择题的答案不能没有"),
    QUESTION_ITEM_ANSWER_SIMPLE("-10013", "单选题的答案只能有一个", "单选题的答案只能有一个"),
    ROOM_IS_USING("-10014", "教室已经被使用", "教室已经被使用"),

    CLASSMATE_IS_USING("-10015", "班级已经被使用", "班级已经被使用"),
    STUDENT_NOT_EXIST("-10016", "还没有选择上课的学生", "还没有选择上课的学生"),
    COURSE_WARE_NOT_EXIST("-10019", "该课程没有课件", "该课程没有课件"),
    COURSEWARE_NOT_SELECT("-10020", "学生没有选择课件", "学生没有选择课件"),
    COURSEWARE_NOT_EXIST("-10021", "课件不存在", "课件不存在"),
    COURSE_NOT_SAME("-10022", "课程不对", "课程不对"),
    MACHINE_STUDENT_NOT_SAME("-10023", "该机床上没有该学生", "该机床上没有该学生"),
    ;;
    private String code;
    private String message;
    private String desc;

    ResultCodeEnum(String code, String message, String desc) {
        this.code = code;
        this.message = message;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
