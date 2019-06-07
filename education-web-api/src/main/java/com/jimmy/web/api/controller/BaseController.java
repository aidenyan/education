package com.jimmy.web.api.controller;

import com.jimmy.dao.entity.TeacherStaffInfo;
import com.jimmy.web.api.local.thread.TeacherLocalThread;

public class BaseController {

    public TeacherStaffInfo getTeacherStaffInfo() {
        return TeacherLocalThread.get();
    }
}
