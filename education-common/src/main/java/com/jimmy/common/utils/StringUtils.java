package com.jimmy.common.utils;

import java.util.UUID;

/**
 * @ClassName: StringUtils
 * @Description:
 * @author: aiden
 * @date: 2019/6/6/006.
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {

    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }
}
