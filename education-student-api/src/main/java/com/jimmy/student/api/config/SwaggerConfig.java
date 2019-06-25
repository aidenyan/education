package com.jimmy.student.api.config;

import com.jimmy.dao.entity.CourseStudent;
import com.jimmy.mvc.common.config.WebConfig;
import com.jimmy.service.CourseStudentService;
import com.jimmy.service.StudentInfoService;
import com.jimmy.service.TokenService;
import com.jimmy.student.api.interceptor.AuthorInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by Administrator on 2019/4/11/011.
 */
@Configuration//需要实力化
@EnableSwagger2//启动swagger，可以写在spring-boot的启动上
public class SwaggerConfig extends WebConfig {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private StudentInfoService studentInfoService;
    @Autowired
    private CourseStudentService courseStudentService;

    /**
     * Docket可以有多个,groupName分组的信息,每个分组可以有自己的类型
     *
     * @return
     */
    @Bean
    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2).groupName("测试样例").select()
                .apis(RequestHandlerSelectors.basePackage("com.jimmy.student.api.controller"))
                .build()
                .apiInfo(apiInfo()).pathMapping("/");

    }

    private ApiInfo apiInfo() {
        /**
         * api的节本信息
         */
        return new ApiInfoBuilder().title("RestAPI Docs")
                .termsOfServiceUrl("")
                .build();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        AuthorInterceptor authorInterceptor = new AuthorInterceptor();
        authorInterceptor.setStudentInfoService(studentInfoService);
        authorInterceptor.setTokenService(tokenService);
        authorInterceptor.setCourseStudentService(courseStudentService);
        registry.addInterceptor(authorInterceptor).addPathPatterns("/admin/**");
    }

}