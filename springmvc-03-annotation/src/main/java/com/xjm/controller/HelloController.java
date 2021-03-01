package com.xjm.controller;

import com.xjm.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Panda
 * @create 2021-03-01 15:12
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model){
        //封装数据
        model.addAttribute("msg","Hello,SpringMVCAnnotation!");
        return "hello";//视图解析器处理
    }

    /**
     *  处理提交数据
     *  1、提交的域名称和处理方法的参数名一致
     */
    @RequestMapping("/hello2")
    public String hello2(String name,Model model){
        System.out.println(name);
        model.addAttribute("msg",name);
        return "hello";
    }

    /**
     * 2、提交的域名称和处理方法的参数名不一致
     */
    //@RequestParam("username") : username提交的域的名称 .
    @RequestMapping("/hello3")
    public String hello3(@RequestParam("username") String name ,Model model){
        System.out.println(name);
        model.addAttribute("msg",name);
        return "hello";
    }

    /**
     * 3、提交的是一个对象
     */
    @RequestMapping("/user")
    public String user(User user ,Model model){
        System.out.println(user);
        model.addAttribute("msg",user.getName());
        return "hello";
    }

}
