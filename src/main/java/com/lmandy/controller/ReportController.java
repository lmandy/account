package com.lmandy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 94993 on 2017/3/17.
 */
@RequestMapping("report")
@Controller
public class ReportController {

    @RequestMapping("personalReport")
    public String personalReport(){
        return "report/personalReport";
    }
    @RequestMapping("teamReport")
    public String teamReport(){
        return "report/teamReport";
    }
}
