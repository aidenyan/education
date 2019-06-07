package com.jimmy.teacher.api.controller;

import com.jimmy.dao.entity.TeacherStaffInfo;
import com.jimmy.teacher.api.local.thread.TeacherLocalThread;


public class BaseController {

    public TeacherStaffInfo getTeacherStaffInfo() {
        return TeacherLocalThread.get();
    }
}
