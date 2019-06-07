package com.jimmy.mvc.common.utils;


import org.springframework.core.LocalVariableTableParameterNameDiscoverer;

import java.lang.reflect.Method;


/**
 * @author aiden
 * @date 2017/3/29
 */
public class BeanUtils extends com.jimmy.common.utils.BeanUtils {
    private static LocalVariableTableParameterNameDiscoverer discoverer = new LocalVariableTableParameterNameDiscoverer();


    public static String[] getParamterName(Method method) {
        try {
            return discoverer.getParameterNames(method);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

}
