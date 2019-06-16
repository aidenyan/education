package com.jimmy.student.api.local.thread;

import com.jimmy.dao.entity.CourseStudent;

public class CourseStudentLocalThread {
    private static ThreadLocal<CourseStudent> courseStudentThreadLocal = new ThreadLocal<>();

    public static CourseStudent get() {
        return courseStudentThreadLocal.get();
    }

    public static void set(CourseStudent courseStudent) {
        courseStudentThreadLocal.set(courseStudent);
    }
}
