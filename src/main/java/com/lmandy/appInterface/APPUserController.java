package com.lmandy.appInterface;

import com.google.gson.Gson;
import com.lmandy.bean.AccountUser;
import com.lmandy.service.app.impl.IAPPUserService;
import com.lmandy.utils.Constants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 94993 on 2017/3/12.
 */
@RequestMapping("appUser")
@Controller
public class APPUserController {

    @Autowired
    private IAPPUserService iappUserService;

    @ResponseBody
    @RequestMapping("register")
    public String register(AccountUser user, MultipartFile multipartFile){
        Map<String,Object> message = new HashMap();

        AccountUser _user = iappUserService.getByName(user.getUserName());
        if(_user == null){
            boolean flag = iappUserService.register(user,multipartFile);
            if(flag){
                message.put("code",200);
            }else {
                message.put("code",-99);
            }
        }else{
            message.put("code",100);
        }



        return new Gson().toJson(message).toString();
    }

    @ResponseBody
    @RequestMapping("login")
    public String login(String userName, String passWord, HttpSession session){
        AccountUser user = iappUserService.getByName(userName);
        Map<String,Object> message = new HashMap();

        if(user == null){
            message.put("code",-99);
        }else{
            if(!passWord.equals(user.getPassWord())){
                message.put("code",-99);
            }else{
                session.setAttribute(user.getToken(),user);
                message.put("code",200);
                message.put("token",user.getToken());
            }
        }
        return new Gson().toJson(message).toString();
    }

    @ResponseBody
    @RequestMapping("getUserByToken")
    public String getAppUserByToken(String token,HttpSession session){
        AccountUser user = (AccountUser) session.getAttribute(token);
        Map<String,Object> message = new HashMap();
        if(user == null){
            message.put("code",-99);
        }else{
            message.put("code",200);
            message.put("user",user);
        }
        return new Gson().toJson(message).toString();
    }

    @ResponseBody
    @RequestMapping("exit")
    public String exit(String token,HttpSession session){
        session.removeAttribute(token);
        return new Gson().toJson(new HashMap().put("code",200)).toString();
    }

}
