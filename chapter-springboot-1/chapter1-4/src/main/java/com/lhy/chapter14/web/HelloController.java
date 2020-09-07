package com.lhy.chapter14.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HelloController {

    @RequestMapping("/")
    public String hello(ModelMap map){
        map.addAttribute("test","test");
        return "index";
    }
}
