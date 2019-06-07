package com.jimmy.teacher.api.local.thread;

import com.jimmy.dao.entity.TeacherStaffInfo;

public class TeacherLocalThread {
    private static ThreadLocal<TeacherStaffInfo> teacherStaffInfoThreadLocal = new ThreadLocal<>();

    public static TeacherStaffInfo get() {
        return teacherStaffInfoThreadLocal.get();
    }

    public static void set(TeacherStaffInfo teacherStaffInfo) {
        teacherStaffInfoThreadLocal.set(teacherStaffInfo);
    }
}
