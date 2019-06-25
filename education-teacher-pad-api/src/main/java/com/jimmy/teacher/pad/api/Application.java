package com.jimmy.teacher.pad.api;


import org.apache.catalina.authenticator.jaspic.AuthConfigFactoryImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * Created by Administrator on 2019/4/10/010.
 */


@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.jimmy.dao")
@ComponentScan(basePackages = {"com.jimmy.core","com.jimmy.service","com.jimmy.mvc","com.jimmy.teacher.pad.api"})
public class Application {
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
