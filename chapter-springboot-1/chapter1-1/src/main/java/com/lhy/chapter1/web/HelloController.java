package com.lhy.chapter1.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloController")
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
    }
}
