package com.jimmy.teacher.pad.api.config;

import com.jimmy.mvc.common.aop.LogAop;
import com.jimmy.mvc.common.config.FilePathConfig;
import com.jimmy.mvc.common.config.GlobalControllerAdvice;
import com.jimmy.mvc.common.config.MybatisConfig;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

@Component
@Import({MybatisConfig.class, LogAop.class,FilePathConfig.class, GlobalControllerAdvice.class})
public class ImportConfig {
}
