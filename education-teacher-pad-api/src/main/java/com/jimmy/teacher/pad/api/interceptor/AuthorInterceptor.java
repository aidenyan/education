package com.jimmy.teacher.pad.api.interceptor;

import com.jimmy.common.utils.StringUtils;
import com.jimmy.core.exception.AuthorException;
import com.jimmy.core.local.thread.LoginLocalThread;
import com.jimmy.core.model.dto.UserLoginBaseDTO;
import com.jimmy.dao.entity.TeacherStaffInfo;
import com.jimmy.service.TeacherStaffInfoService;
import com.jimmy.service.TokenService;
import com.jimmy.teacher.pad.api.local.thread.TeacherLocalThread;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthorInterceptor implements HandlerInterceptor {

    private static final String HEADER_TOKEN = "token";
    private TokenService tokenService;

    private TeacherStaffInfoService teacherStaffInfoService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String token = request.getHeader(HEADER_TOKEN);
        if (token == null) {
            throw new AuthorException("not login");
        }
        UserLoginBaseDTO userLoginBaseDTO = tokenService.analysisToken(token);
        if (userLoginBaseDTO == null || userLoginBaseDTO.getUseId() == null) {
            throw new AuthorException("not login");
        }
        TeacherStaffInfo teacherStaffInfo = teacherStaffInfoService.findById(userLoginBaseDTO.getUseId());
        if (teacherStaffInfo == null) {
            throw new AuthorException("not login");
        }
        if (StringUtils.isBlank(userLoginBaseDTO.getToken())) {
            throw new AuthorException("not login");
        }
        if (!userLoginBaseDTO.getToken().equals(teacherStaffInfo.getPadAppToken())) {
            throw new AuthorException("not login");
        }
        TeacherLocalThread.set(teacherStaffInfo);
        LoginLocalThread.set(teacherStaffInfo.getId());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    public void setTokenService(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    public void setTeacherStaffInfoService(TeacherStaffInfoService teacherStaffInfoService) {
        this.teacherStaffInfoService = teacherStaffInfoService;
    }
}
