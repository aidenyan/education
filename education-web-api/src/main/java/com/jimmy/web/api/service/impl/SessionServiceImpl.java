package com.jimmy.web.api.service.impl;

import com.alibaba.fastjson.JSON;
import com.jimmy.common.utils.EncryptUtil;
import com.jimmy.dao.entity.MenuInfo;
import com.jimmy.dao.entity.TeacherStaffInfo;
import com.jimmy.mvc.common.local.thread.RequestLocalThread;
import com.jimmy.mvc.common.local.thread.ResponseLocalThread;
import com.jimmy.mvc.common.model.dto.CookieValueDTO;
import com.jimmy.mvc.common.model.enums.StaffTypeEnum;
import com.jimmy.service.MenuInfoService;
import com.jimmy.service.TeacherStaffInfoService;
import com.jimmy.web.api.local.thread.TeacherLocalThread;
import com.jimmy.web.api.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class SessionServiceImpl implements SessionService {
    private static final String SESSION_USER_LOGIN_KEY = "SESSION_USER_LOGIN_KEY";
    private static final String SESSION_MENU_LIST_KEY = "SESSION_MENU_LIST_KEY";
    private static final String COOKIE_USER_LOGIN_KEY = "token";
    private static final Integer MAX_TIME = 30;
    private static final String ENCRY_SECRET_KEY = SessionService.class.getName();

    private static final boolean isCookie = true;


    @Autowired
    private MenuInfoService menuInfoService;

    @Autowired
    private TeacherStaffInfoService teacherStaffInfoService;


    private TeacherStaffInfo findByCookie() {
        Long teacherId = getLoginId();
        if (teacherId == null) {
            return null;
        }
        TeacherStaffInfo teacherStaffInfo = teacherStaffInfoService.findById(teacherId);
        if (teacherStaffInfo != null) {
            saveCookie(teacherStaffInfo);
        }
        return teacherStaffInfo;
    }

    private Cookie getCookie(String name) {
        HttpServletRequest request = RequestLocalThread.get();
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return null;
        }
        List<Cookie> cookieList = Arrays.asList(cookies).stream().filter(cookie -> COOKIE_USER_LOGIN_KEY.equals(cookie.getName())).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(cookieList)) {
            return null;
        }
        for (Cookie cookie : cookieList) {
            if (name.equals(cookie.getName())) {
                return cookie;
            }
        }
        return null;
    }

    private Long getLoginId() {
        Cookie cookie = getCookie(COOKIE_USER_LOGIN_KEY);
        if (cookie == null) {
            return null;
        }
        String content = cookie.getValue();
        CookieValueDTO cookieValueDTO = JSON.parseObject(content, CookieValueDTO.class);
        if (cookieValueDTO == null) {
            return null;
        }
        if (!md5(cookieValueDTO).equals(cookieValueDTO.getKey())) {
            return null;
        }
        if (System.currentTimeMillis() - cookieValueDTO.getTime() > MAX_TIME * 60 * 1000L) {
            return null;
        }
        return cookieValueDTO.getLoginId();
    }

    private TeacherStaffInfo findBySession() {
        HttpServletRequest request = RequestLocalThread.get();
        HttpSession session = request.getSession();
        TeacherStaffInfo teacherStaffInfo = (TeacherStaffInfo) session.getAttribute(SESSION_USER_LOGIN_KEY);
        return teacherStaffInfo;
    }

    @Override
    public TeacherStaffInfo find() {
        if (isCookie) {
            return findByCookie();
        } else {
            return findBySession();
        }
    }

    @Override
    public void save(TeacherStaffInfo teacherStaffInfo) {
        if (isCookie) {
            saveCookie(teacherStaffInfo);
        } else {
            saveSession(teacherStaffInfo);
        }
    }

    private void saveCookie(TeacherStaffInfo teacherStaffInfo) {
        HttpServletResponse response = ResponseLocalThread.get();
        Cookie cookie = getCookie(COOKIE_USER_LOGIN_KEY);

        CookieValueDTO cookieValueDTO = new CookieValueDTO();
        cookieValueDTO.setLoginId(teacherStaffInfo.getId());
        cookieValueDTO.setTime(System.currentTimeMillis());
        cookieValueDTO.setKey(md5(cookieValueDTO));
        if (cookie == null) {
            cookie = new Cookie(COOKIE_USER_LOGIN_KEY, JSON.toJSONString(cookieValueDTO));
        } else {
            cookie.setValue(JSON.toJSONString(cookieValueDTO));
        }
        cookie.setPath("/");
        cookie.setMaxAge(30 * 60);
        response.addCookie(cookie);
    }

    private void saveSession(TeacherStaffInfo teacherStaffInfo) {
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
        if (isCookie) {
            return listMenuInfoByCookie();
        } else {
            return listMenuInfoBySession();
        }
    }

    private String md5(CookieValueDTO cookieValueDTO) {
        return EncryptUtil.encryptMd5(String.valueOf(cookieValueDTO.getLoginId() + cookieValueDTO.getTime()), ENCRY_SECRET_KEY);

    }

    public List<MenuInfo> listMenuInfoByCookie() {
        TeacherStaffInfo teacherStaffInfo = TeacherLocalThread.get();
        if (teacherStaffInfo == null) {
            teacherStaffInfo = find();
        }
        List<MenuInfo> menuInfoList;
        if (StaffTypeEnum.SCHOOL_MASTER.getValue() == teacherStaffInfo.getStaffType()) {
            menuInfoList = menuInfoService.list();
        } else {
            menuInfoList = menuInfoService.list(teacherStaffInfo.getId());
        }
        return menuInfoList;
    }

    public List<MenuInfo> listMenuInfoBySession() {
        HttpServletRequest request = RequestLocalThread.get();
        HttpSession session = request.getSession();
        List<MenuInfo> menuInfoList = (List<MenuInfo>) session.getAttribute(SESSION_MENU_LIST_KEY);
        return menuInfoList;
    }

    @Override
    public void out() {
        if (isCookie) {
            HttpServletRequest request = RequestLocalThread.get();
            HttpSession session = request.getSession();
            session.invalidate();
        } else {
            Cookie cookie = getCookie(COOKIE_USER_LOGIN_KEY);
            if (cookie == null) {
                return;
            }
            cookie.setMaxAge(0);
            HttpServletResponse response = ResponseLocalThread.get();
            response.addCookie(cookie);
        }

    }
}


