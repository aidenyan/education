package com.jimmy.student.api.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "student.config")
@Data
public class StudentConfig {

    private String token;

    private String studentUrl;
}
