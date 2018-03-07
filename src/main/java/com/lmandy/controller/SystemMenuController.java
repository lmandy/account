package com.lmandy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 94993 on 2017/3/16.
 */
@RequestMapping("menu")
@Controller
public class SystemMenuController {

    @RequestMapping("index")
    public String index(){
        return "set/menu";
    }
}
