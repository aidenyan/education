package com.jimmy.student.api;


import com.jimmy.student.api.websocket.WebSocket;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * Created by Administrator on 2019/4/10/010.
 */


@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.jimmy.dao")
@ComponentScan(basePackages = {"com.jimmy.student.api", "com.jimmy.core", "com.jimmy.service", "com.jimmy.mvc"})
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(Application.class, args);
        //解决WebSocket不能注入的问题
        WebSocket.setApplicationContext(configurableApplicationContext);
    }
}
