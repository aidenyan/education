package com.jimmy.student.api.controller;

import com.jimmy.dao.entity.StudentInfo;
import com.jimmy.student.api.local.thread.StudentLocalThread;


public class BaseController {

    public StudentInfo getStudentInfo() {
        return StudentLocalThread.get();
    }
}
