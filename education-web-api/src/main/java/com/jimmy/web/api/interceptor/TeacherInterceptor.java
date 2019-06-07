package com.jimmy.web.api.interceptor;

import com.jimmy.dao.entity.TeacherStaffInfo;
import com.jimmy.service.SiteInfoService;
import com.jimmy.web.api.service.SessionService;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TeacherInterceptor implements HandlerInterceptor {
    private SessionService sessionService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse httpServletResponse, Object o) throws Exception {
       TeacherStaffInfo teacherStaffInfo= sessionService.find();
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    public void setSessionService(SessionService sessionService) {
        this.sessionService = sessionService;
    }
}
