package com.lmandy.controller;

import com.lmandy.bean.AccountSystemMenu;
import com.lmandy.bean.AccountSystemUser;
import com.lmandy.service.backstage.ISystemRoleService;
import com.lmandy.service.backstage.ISystemUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 94993 on 2017/3/10.
 */
@Controller
public class IndexController {

    @Autowired
    private ISystemUserService iSystemUserService;
    @Autowired
    private ISystemRoleService iSystemRoleService;

    @RequestMapping("/login")
    public String login(String userName, String passWord, Model model, HttpSession session){
        AccountSystemUser user = iSystemUserService.getByName(userName);
        if(user != null && passWord.equals(user.getPassWord())){
            session.setAttribute("user",user);
            return "redirect:/index";
        }else{
            model.addAttribute("error","用户名或密码错误!");
            return "login";
        }


//
//        //使用shiro
//       try {
//           Subject subject = SecurityUtils.getSubject();
//           subject.login(new UsernamePasswordToken(userName,passWord));
//           subject.getSession().setAttribute("user",subject.getPrincipal());
//
//           return "redirect:/";
//       }catch (Exception e){
//           model.addAttribute("error","用户名或密码错误!");
//           return "login";
//       }
    }

    @RequestMapping("logout")
    public String logout(){
        SecurityUtils.getSubject().logout();
        return "login";
    }

    @RequestMapping("/")
    public String index(){

        return "index";
    }

    @RequestMapping("/nav")
    public String nav(HttpSession session,Model model){
        //获取用户访问权限列表
        AccountSystemUser user = (AccountSystemUser) session.getAttribute("user");
        List<AccountSystemMenu> menus = iSystemRoleService.getByUserId(user.getId());
        model.addAttribute("menus",menus);
        return "nav";
    }
    @RequestMapping("/top")
    public String top(){
        return "top";
    }
    @RequestMapping("/homePage")
    public String homePage(){
        return "homePage";
    }

    /**
     * 权限不足，403页面
     */
    @RequestMapping("403")
    public String unauthorized(){
        return "403";
    }
}

