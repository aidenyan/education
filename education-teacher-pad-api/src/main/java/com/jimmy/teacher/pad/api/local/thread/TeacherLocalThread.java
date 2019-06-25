package com.jimmy.teacher.pad.api.local.thread;

import com.jimmy.dao.entity.TeacherStaffInfo;

public class TeacherLocalThread {
    private static ThreadLocal<TeacherStaffInfo> teacherStaffInfoThreadLocal = new ThreadLocal<>();

    public static TeacherStaffInfo get() {
        return teacherStaffInfoThreadLocal.get();
    }

    public static void set(TeacherStaffInfo teacherStaffInfo) {
        if(teacherStaffInfo!=null){
            teacherStaffInfo.setPassword(null);
        }
        teacherStaffInfoThreadLocal.set(teacherStaffInfo);
    }
}
