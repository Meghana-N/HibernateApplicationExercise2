package com.stackroute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {
    User user = new User();

    @RequestMapping(value = "/")
    public String userInfo(){
        return "index";
    }

    @RequestMapping(value = "login")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response)
    {
        user.setUserName(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));

        String message = "Welcome to Stackroute " + user.getUserName();

        ModelAndView modelView = new ModelAndView();
        modelView.setViewName("display");
        modelView.addObject("result",message);
        return modelView;

    }
}
