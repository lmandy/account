package com.lmandy.utils;

import java.util.UUID;

/**
 * Created by 94993 on 2017/3/6.
 */
public class UUIDUtil {
    /**
     * 获取uuid 去除 ‘-’
     * @return
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
