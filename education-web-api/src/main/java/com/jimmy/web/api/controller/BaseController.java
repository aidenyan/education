package com.jimmy.web.api.controller;

import com.github.pagehelper.PageHelper;
import com.jimmy.core.consts.PageConst;
import com.jimmy.dao.entity.TeacherStaffInfo;
import com.jimmy.web.api.local.thread.TeacherLocalThread;

public class BaseController {

    public TeacherStaffInfo getTeacherStaffInfo() {
        return TeacherLocalThread.get();
    }

    public void setPage(Integer pageNo, Integer pageSize) {
        if (pageNo == null) {
            pageNo = PageConst.PAGE_FIRST;
        }
        if (pageSize == null) {
            pageSize = PageConst.PAGE_DEFAULT_SIZE;
        }
        PageHelper.startPage(pageNo, pageSize);
    }

}
