package com.jimmy.student.api.interceptor;

import com.jimmy.common.utils.StringUtils;
import com.jimmy.core.exception.AuthorException;
import com.jimmy.core.local.thread.LoginLocalThread;
import com.jimmy.core.model.dto.UserLoginBaseDTO;
import com.jimmy.dao.entity.CourseStudent;
import com.jimmy.dao.entity.StudentInfo;
import com.jimmy.service.CourseStudentService;
import com.jimmy.service.StudentInfoService;
import com.jimmy.service.TokenService;
import com.jimmy.student.api.local.thread.CourseStudentLocalThread;
import com.jimmy.student.api.local.thread.StudentLocalThread;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthorInterceptor implements HandlerInterceptor {

    private static final String HEADER_TOKEN = "token";
    private TokenService tokenService;

    private StudentInfoService studentInfoService;

    private CourseStudentService courseStudentService;

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
        CourseStudent courseStudent = courseStudentService.find(userLoginBaseDTO.getUseId());

        StudentInfo studentInfo = studentInfoService.findById(courseStudent.getStudentId());
        if (studentInfo == null) {
            throw new AuthorException("not login");
        }
        if (StringUtils.isBlank(userLoginBaseDTO.getToken())) {
            throw new AuthorException("not login");
        }
        if (!userLoginBaseDTO.getToken().equals(studentInfo.getAppToken())) {
            throw new AuthorException("not login");
        }
        StudentLocalThread.set(studentInfo);
        LoginLocalThread.set(studentInfo.getId());
        CourseStudentLocalThread.set(courseStudent);
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

    public void setStudentInfoService(StudentInfoService studentInfoService) {
        this.studentInfoService = studentInfoService;
    }

    public void setCourseStudentService(CourseStudentService courseStudentService) {
        this.courseStudentService = courseStudentService;
    }
}
