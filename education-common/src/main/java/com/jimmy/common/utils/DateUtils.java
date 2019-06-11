package com.jimmy.common.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName: DateUtils
 * @Description:
 * @author: aiden
 * @date: 2019/6/11/011.
 */
public class DateUtils {
    public static Date getWeekStart() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.DAY_OF_WEEK, 2);
        return calendar.getTime();
    }
}
