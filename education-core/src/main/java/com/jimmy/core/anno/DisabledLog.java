package com.jimmy.core.anno;


import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.METHOD})    
@Retention(RetentionPolicy.RUNTIME)    
@Documented  
public @interface DisabledLog {


}
