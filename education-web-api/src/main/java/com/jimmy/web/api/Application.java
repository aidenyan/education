package com.jimmy.web.api;


import org.apache.tomcat.util.http.LegacyCookieProcessor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * Created by Administrator on 2019/4/10/010.
 */


@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.jimmy.dao")
@ComponentScan(basePackages = {"com.jimmy.core", "com.jimmy.service", "com.jimmy.mvc", "com.jimmy.web.api"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public EmbeddedServletContainerCustomizer customizer() {
        return container -> {
            if (container instanceof TomcatEmbeddedServletContainerFactory) {
                TomcatEmbeddedServletContainerFactory tomcat = (TomcatEmbeddedServletContainerFactory) container;
                tomcat.addContextCustomizers(context -> context.setCookieProcessor(new LegacyCookieProcessor()));
            }
        };
    }
}
