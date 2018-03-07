package com.lmandy.utils;

import java.util.ResourceBundle;

/**
 * Created by 94993 on 2017/3/6.
 */
public class Constants {

    public static String baseUrl;
    public static String imageUrl;
    public static String userImgUrl;
    public static String visitUrl;


    static {

        ResourceBundle bundle = ResourceBundle.getBundle("global");
        baseUrl = bundle.getString("baseUrl");
        imageUrl = bundle.getString("imageUrl");
        userImgUrl = bundle.getString("userImgUrl");
        visitUrl = bundle.getString("visitUrl");
    }
}
