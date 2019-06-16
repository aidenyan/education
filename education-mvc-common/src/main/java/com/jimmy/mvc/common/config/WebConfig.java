package com.jimmy.mvc.common.config;

import com.jimmy.mvc.common.interceptor.SiteInterceptor;
import com.jimmy.service.SiteInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private SiteInfoService siteInfoService;

    @Autowired
    private FilePathConfig filePathConfig;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        SiteInterceptor siteInterceptor = new SiteInterceptor();
        siteInterceptor.setSiteInfoService(siteInfoService);
        registry.addInterceptor(siteInterceptor).addPathPatterns("/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/upload/**").addResourceLocations("file:" + filePathConfig.getFilePath().replace("\\", "/") + "/");

    }
}
