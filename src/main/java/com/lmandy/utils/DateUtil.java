package com.lmandy.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 94993 on 2017/3/3.
 */
public class DateUtil {

    private static DateFormat format;

    /**时间转换成字符串
     * @param date 时间
     * @param f 转换格式
     * @return
     */
    public static String dateToString(Date date,String f){
        format = new SimpleDateFormat(f);
        return format.format(date);
    }
}
