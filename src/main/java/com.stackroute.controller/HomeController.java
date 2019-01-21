package com.stackroute.controller;

import com.stackroute.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Controller
public class HomeController {
    @Autowired
    private UserDao userDao;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @RequestMapping("/display")
    public ModelAndView showMessage(@ModelAttribute("user") User user, ModelAndView modelAndView) {
        modelAndView.setViewName("display");
        modelAndView.addObject("userObject", user);
        userDao.persist(user);
        return modelAndView;
    }
}
