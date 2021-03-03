package com.xjm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xjm.pojo.User;
import com.xjm.utils.JsonUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Panda
 * @create 2021-03-03 1:06
 */
@RestController
public class UserController {

    @RequestMapping("/j1")
    public String json1() throws JsonProcessingException {
        User user = new User("谢健民",18,"男");
        ObjectMapper mapper = new ObjectMapper();
        String str = mapper.writeValueAsString(user);
        return str;
    }

    @RequestMapping("/j2")
    public String json2() throws JsonProcessingException {
        Date date = new Date();
        String json = JsonUtils.getJson(date);
        return json;
    }
    @RequestMapping("/j3")
    public String json3() throws JsonProcessingException {
        List<User> userList = new ArrayList<User>();
        User user1 = new User("谢健民1号",18,"男");
        User user2 = new User("谢健民2号",18,"男");
        User user3 = new User("谢健民3号",18,"男");
        User user4 = new User("谢健民4号",18,"男");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        String str = JSON.toJSONString(userList);

        System.out.println("*******Java对象 转 JSON字符串*******");
        String str1 = JSON.toJSONString(userList);
        System.out.println("JSON.toJSONString(list)==>"+str1);
        String str2 = JSON.toJSONString(user1);
        System.out.println("JSON.toJSONString(user1)==>"+str2);

        System.out.println("\n****** JSON字符串 转 Java对象*******");
        User jp_user1=JSON.parseObject(str2,User.class);
        System.out.println("JSON.parseObject(str2,User.class)==>"+jp_user1);

        System.out.println("\n****** Java对象 转 JSON对象 ******");
        JSONObject jsonObject1 = (JSONObject) JSON.toJSON(user2);
        System.out.println("(JSONObject) JSON.toJSON(user2)==>"+jsonObject1.getString("name"));

        System.out.println("\n****** JSON对象 转 Java对象 ******");
        User to_java_user = JSON.toJavaObject(jsonObject1, User.class);
        System.out.println("JSON.toJavaObject(jsonObject1, User.class)==>"+to_java_user);

        return "hello";
    }
}
