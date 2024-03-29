package com.jimmy.teacher.api.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "teacher.config")
@Data
public class TeacherConfig {
    private Long dictionaryId;

    private String token;

    private String studentUrl;
}
