package com.xjm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Panda
 * @create 2021-03-04 14:26
 */

@RestController
public class HelloController {

    @GetMapping("/t1")
    public String test(){
        System.out.println("test");
        return "OK";
    }
}
