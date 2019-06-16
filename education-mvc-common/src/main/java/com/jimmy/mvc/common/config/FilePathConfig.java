package com.jimmy.mvc.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "upload.config")
@Data
public class FilePathConfig {
    private String filePath;
}
