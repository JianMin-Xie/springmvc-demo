package com.xjm.controller;

import com.xjm.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Panda
 * @create 2021-03-04 11:13
 */
@RestController
public class AjaxController {
    @RequestMapping("t1")
    public String test(){
        return "hello";
    }

    @RequestMapping("/a1")
    public void a1(String name , HttpServletResponse response) throws IOException {
        if ("admin".equals(name)){
            response.getWriter().print("true");
        }else{
            response.getWriter().print("false");
        }
    }

    @RequestMapping("/a2")
    public List<User> a2(){
        ArrayList<User> userList = new ArrayList<User>();
        userList.add(new User("谢健民Java",18,"男"));
        userList.add(new User("谢健民前端",1,"男"));
        userList.add(new User("谢健民运维",50,"男"));
        return userList;
    }

    @RequestMapping("/a3")
    public String a3(String name,String pwd){
        String msg = "";
        if (name != null) {
            if("admin".equals(name)){
                msg = "ok";
            }
            else {
                msg = "用户名有误";
            }
        }
        if (pwd != null) {
            if("123".equals(pwd)){
                msg = "ok";
            }
            else {
                msg = "密码有误";
            }
        }
        return msg;
    }

}
