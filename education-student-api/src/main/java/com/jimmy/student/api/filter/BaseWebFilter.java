package com.jimmy.student.api.filter;

import com.alibaba.fastjson.JSON;
import com.jimmy.core.enums.OperationSysEnum;
import com.jimmy.core.enums.ResultCoreEnum;
import com.jimmy.core.local.thread.LoginLocalThread;
import com.jimmy.core.local.thread.OperationSysLocalThread;
import com.jimmy.core.local.thread.SysLogUuidLocalThread;
import com.jimmy.dao.local.thread.SiteLocalThread;
import com.jimmy.mvc.common.base.Result;
import com.jimmy.mvc.common.local.thread.RequestLocalThread;
import com.jimmy.mvc.common.local.thread.ResponseLocalThread;
import com.jimmy.student.api.local.thread.CourseStudentLocalThread;
import com.jimmy.student.api.local.thread.StudentLocalThread;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

@Component
@javax.servlet.annotation.WebFilter(urlPatterns = "/api/**")
public class BaseWebFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        RequestLocalThread.set((HttpServletRequest) request);
        ResponseLocalThread.set((HttpServletResponse) response);
        OperationSysLocalThread.set(OperationSysEnum.STUDENT);
        SysLogUuidLocalThread.set(UUID.randomUUID().toString());
        try {
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            Result<Void> resultModel = new Result<>(ResultCoreEnum.RESULT_EXCEPTION_SYS);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            PrintWriter out = response.getWriter();
            out.append(JSON.toJSONString(resultModel));
            out.close();
        }
        RequestLocalThread.set(null);
        ResponseLocalThread.set(null);
        OperationSysLocalThread.set(null);
        SysLogUuidLocalThread.set(null);
        SiteLocalThread.setSiteId(null);
        SiteLocalThread.setSiteIdList(null);
        StudentLocalThread.set(null);
        LoginLocalThread.set(null);
        CourseStudentLocalThread.set(null);
    }

    @Override
    public void destroy() {

    }
}
