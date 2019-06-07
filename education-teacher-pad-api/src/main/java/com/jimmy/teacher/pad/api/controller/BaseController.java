package com.jimmy.teacher.pad.api.controller;

import com.jimmy.dao.entity.TeacherStaffInfo;
import com.jimmy.teacher.pad.api.local.thread.TeacherLocalThread;


public class BaseController {

    public TeacherStaffInfo getTeacherStaffInfo() {
        return TeacherLocalThread.get();
    }
}
