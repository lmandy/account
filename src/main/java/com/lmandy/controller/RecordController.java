package com.lmandy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 94993 on 2017/3/17.
 */
@RequestMapping("record")
@Controller
public class RecordController {

    @RequestMapping("personalRecord")
    public String personalRecord(){
        return "record/personalRecord";
    }
    @RequestMapping("teamRecord")
    public String teamRecord(){
        return "record/teamRecord";
    }
}
