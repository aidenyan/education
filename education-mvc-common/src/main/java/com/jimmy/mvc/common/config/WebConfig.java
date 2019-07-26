package com.jimmy.mvc.common.config;

import com.jimmy.mvc.common.interceptor.SiteInterceptor;
import com.jimmy.service.SiteInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
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

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }

    @Bean(name = "multipartResolver")
    public MultipartResolver multipartResolver(){
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        resolver.setResolveLazily(true);//resolveLazily����������Ϊ���Ƴ��ļ�������������UploadAction�в����ļ���С�쳣
        resolver.setMaxInMemorySize(40960);
        resolver.setMaxUploadSize(50*1024*1024);//�ϴ��ļ���С 50M 50*1024*1024
        return resolver;
    }
}
