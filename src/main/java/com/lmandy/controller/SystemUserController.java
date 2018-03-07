package com.lmandy.controller;

import com.lmandy.bean.AccountSystemUser;
import com.lmandy.service.backstage.ISystemUserService;
import com.lmandy.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 后台系统用户登录
 * Created by 94993 on 2017/2/26.
 */
@RequestMapping("user")
@Controller
public class SystemUserController {

    @Autowired
    private ISystemUserService userService;

    @RequestMapping("index")
    public String index(Integer pageNo,Model model){

        PageBean<AccountSystemUser> PageBean = new PageBean<>(pageNo,null,null);

        userService.indexInfo(PageBean);

        PageBean.setUrl("user/index");

        model.addAttribute("page",PageBean);

        return "set/user";
    }

}
