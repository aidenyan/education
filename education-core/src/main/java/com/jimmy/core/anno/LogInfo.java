package com.jimmy.core.anno;


import com.jimmy.core.enums.ObjTypeEnum;
import com.jimmy.core.enums.OperationEnum;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogInfo {
    ObjTypeEnum type();

    OperationEnum operation();

    String param() default "";

}
