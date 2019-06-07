package com.jimmy.student.api.local.thread;

import com.jimmy.dao.entity.StudentInfo;

public class StudentLocalThread {
    private static ThreadLocal<StudentInfo> studentInfoThreadLocal = new ThreadLocal<>();

    public static StudentInfo get() {
        return studentInfoThreadLocal.get();
    }

    public static void set(StudentInfo studentInfo) {
        studentInfo.setPassword(null);
        studentInfoThreadLocal.set(studentInfo);
    }
}
