package com.xjm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author Panda
 * @create 2021-03-04 14:54
 */
@Controller
@RequestMapping("/user")
public class LoginController {
    @RequestMapping("/login")
    public String login(HttpSession session, String username, String password, Model model){
        session.setAttribute("userLoginInfo",username);
        model.addAttribute("username",username);
        return "main";
    }
    @RequestMapping("/goOut")
    public String goOut(HttpSession session, String username, String password, Model model){
        session.removeAttribute("userLoginInfo");
        return "main";
    }
    @RequestMapping("/goLogin")
    public String goLogin(){
        return "login";
    }

    @RequestMapping("/main")
    public String main(){
        return "main";
    }

}
