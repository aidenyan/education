package com.jimmy.student.api.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2019/5/5/005.
 */
@Configuration
public class SpringWebConfig {


    @Bean
    public ServletRegistrationBean servletRegistrationBean(DispatcherServlet dispatcherServlet) {
        ServletRegistrationBean servletServletRegistrationBean = new ServletRegistrationBean(dispatcherServlet);
        servletServletRegistrationBean.addUrlMappings("/student/*");
        servletServletRegistrationBean.addUrlMappings("/api/*");
        return servletServletRegistrationBean;
    }
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
    @Bean
    public ExecutorService executorService() {
        return Executors.newCachedThreadPool();
    }

}
