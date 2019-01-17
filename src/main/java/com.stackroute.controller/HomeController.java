package com.stackroute.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping(value = "/")
    public String userInfo(ModelMap map){
        User user = new User("Bob",20);
        map.addAttribute("Username",user.getUserName());
        return "index";
    }
}
