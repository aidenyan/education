package com.jimmy.web.api.service.impl;

import com.jimmy.dao.entity.MenuInfo;
import com.jimmy.dao.entity.TeacherStaffInfo;
import com.jimmy.mvc.common.local.thread.RequestLocalThread;
import com.jimmy.web.api.service.SessionService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Service
public class SessionServiceImpl implements SessionService {
    private static final String SESSION_USER_LOGIN_KEY = "SESSION_USER_LOGIN_KEY";
    private static final String SESSION_MENU_LIST_KEY = "SESSION_MENU_LIST_KEY";

    @Override
    public TeacherStaffInfo find() {
        HttpServletRequest request = RequestLocalThread.get();
        HttpSession session = request.getSession();
        TeacherStaffInfo teacherStaffInfo = (TeacherStaffInfo) session.getAttribute(SESSION_USER_LOGIN_KEY);
        return teacherStaffInfo;
    }

    @Override
    public void save(TeacherStaffInfo teacherStaffInfo) {
        HttpServletRequest request = RequestLocalThread.get();
        HttpSession session = request.getSession();
        teacherStaffInfo.setPassword(null);
        session.setAttribute(SESSION_USER_LOGIN_KEY, teacherStaffInfo);
    }

    @Override
    public void save(List<MenuInfo> menuInfoList) {
        HttpServletRequest request = RequestLocalThread.get();
        HttpSession session = request.getSession();
        session.setAttribute(SESSION_MENU_LIST_KEY, menuInfoList);
    }

    @Override
    public List<MenuInfo> listMenuInfo() {
        HttpServletRequest request = RequestLocalThread.get();
        HttpSession session = request.getSession();
        List<MenuInfo> menuInfoList = (List<MenuInfo>) session.getAttribute(SESSION_MENU_LIST_KEY);
        return menuInfoList;
    }

    @Override
    public void out() {
        HttpServletRequest request = RequestLocalThread.get();
        HttpSession session = request.getSession();
        session.invalidate();
    }
}


